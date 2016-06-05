package com.repositories.artifacts;

import com.businesslogic.artifacts.TestTask;
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

    public TestTaskRepository() throws SQLException, IOException{
        TestTaskList = new ArrayList<TestTask>();
        TestTaskList.add(new TestTask("test task"));
    }

    public TestTaskRepository(DataSource dataSource) {
        TestTaskList = new ArrayList<TestTask>();
    }

    public List<TestTask> getAll() {
        return this.TestTaskList;
    }

    public TestTask get(TestTask m_task) {
        List<TestTask> m_list = TestTaskList.stream()
                .filter(entry -> entry.getId() == m_task.getId())
                .collect(Collectors.toList());
        return m_list.get(0);
    }

    public void create(TestTask m_task) {
        TestTaskList.add(m_task);
    }

    public void update(TestTask m_task) {
//        TestTaskList.stream()
//                .filter(entry -> entry.getId() == m_task.getId())
//                .forEach(entry ->
//                        entry.setTaskText(m_task.getText()));
    }

    public void delete(TestTask m_task) {
        TestTaskList.removeIf(entry -> entry.getId() == m_task.getId());
    }

    public void disconnect() throws SQLException {
    }
}
