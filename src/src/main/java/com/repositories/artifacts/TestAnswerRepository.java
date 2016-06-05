package com.repositories.artifacts;

import com.businesslogic.artifacts.TestAnswer;
import com.mappers.artifacts.TestAnswerMapper;
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
public class TestAnswerRepository implements Repository<TestAnswer> {
    private static List<TestAnswer> TestAnswerList;
    private static TestAnswerMapper m_testAnswerMapper;

    public TestAnswerRepository() throws SQLException, IOException {
        TestAnswerList = new ArrayList<TestAnswer>();
        DataSourceGateway gateway = DataSourceGateway.getInstance();
        m_testAnswerMapper = new TestAnswerMapper(DataSourceGateway.getDataSource());
        TestAnswerList.add(new TestAnswer(12, 2, "test answer"));
    }

    public TestAnswerRepository(DataSource dataSource) throws SQLException {
        TestAnswerList = new ArrayList<TestAnswer>();
        m_testAnswerMapper = new TestAnswerMapper(dataSource);
    }

    public List<TestAnswer> getAll() {
        return this.TestAnswerList;
    }

    public TestAnswer get(TestAnswer m_answer) throws SQLException{
        List<TestAnswer> m_list = TestAnswerList.stream()
                .filter(entry -> entry.getId() == m_answer.getId())
                .collect(Collectors.toList());
        if (m_list.isEmpty()) {
            TestAnswer answer = m_testAnswerMapper.find(m_answer.getId());
            m_list.add(answer);
            return answer;
        }
        return m_list.get(0);
    }

    public void create(TestAnswer m_answer) throws SQLException {
        TestAnswerList.add(m_answer);
        m_testAnswerMapper.insert(m_answer);
    }

    public void update(TestAnswer m_answer) throws SQLException{
        TestAnswerList.stream()
                .filter(entry -> entry.getId() == m_answer.getId())
                .forEach(entry ->
                        entry.setAnswer(m_answer.getText()));
        m_testAnswerMapper.update(m_answer);
    }

    public void delete(TestAnswer m_answer) throws SQLException {
        TestAnswerList.removeIf(entry -> entry.getId() == m_answer.getId());
        m_testAnswerMapper.delete(m_answer);
    }

    public void disconnect() throws SQLException {
        m_testAnswerMapper.closeConnection();
    }
}
