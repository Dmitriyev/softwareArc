package com.repositories.artifacts;

import com.businesslogic.artifacts.TestTask;
import com.mappers.artifacts.TestTaskMapper;
import com.mappers.database.DataSourceGateway;
import com.repositories.Repository;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pitochka on 05.06.16.
 */
public class TestTaskRepository implements Repository<TestTask> {
    private static List<TestTask> TestTaskList;
    private static TestTaskMapper m_testTaskMapper;

    public TestTaskRepository() throws SQLException, IOException {
        TestTaskList = new ArrayList<TestTask>();
        DataSourceGateway gateway = DataSourceGateway.getInstance();
        m_testTaskMapper = new TestTaskMapper(DataSourceGateway.getDataSource());
        TestTaskList.add(new TestTask("test task"));
    }

    public TestTaskRepository(DataSource dataSource) throws SQLException {
        TestTaskList = new ArrayList<TestTask>();
        m_testTaskMapper = new TestTaskMapper(dataSource);
    }

    public List<TestTask> getAll() {
        return this.TestTaskList;
    }

    public TestTask get(TestTask m_task) throws SQLException{
        List<TestTask> m_list = TestTaskList.stream()
                .filter(entry -> entry.getId() == m_task.getId())
                .collect(Collectors.toList());
        if (m_list.isEmpty()) {
            TestTask task = m_testTaskMapper.find(m_task.getId());
            m_list.add(task);
            return task;
        }
        return m_list.get(0);
    }

    public void create(TestTask m_task) throws SQLException {
        TestTaskList.add(m_task);
        m_testTaskMapper.insert(m_task);
    }

    public void update(TestTask m_task) throws SQLException{
        TestTaskList.stream()
                .filter(entry -> entry.getId() == m_task.getId())
                .forEach(entry ->
                        entry.setTestId(m_task.getTestId()));
        m_testTaskMapper.update(m_task);
    }

    public void delete(TestTask m_task) throws SQLException {
        TestTaskList.removeIf(entry -> entry.getId() == m_task.getId());
        m_testTaskMapper.delete(m_task);
    }

    public void disconnect() throws SQLException {
        m_testTaskMapper.closeConnection();
    }
}
