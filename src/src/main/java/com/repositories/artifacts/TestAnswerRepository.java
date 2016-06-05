package com.repositories.artifacts;

import com.businesslogic.artifacts.TestAnswer;
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

    public TestAnswerRepository() throws SQLException, IOException{
        TestAnswerList = new ArrayList<TestAnswer>();
        TestAnswerList.add(new TestAnswer(12, 2, "test answer"));
    }

    public TestAnswerRepository(DataSource dataSource) {
        TestAnswerList = new ArrayList<TestAnswer>();
    }

    public List<TestAnswer> getAll() {
        return this.TestAnswerList;
    }

    public TestAnswer get(TestAnswer m_answer) {
        List<TestAnswer> m_list = TestAnswerList.stream()
                .filter(entry -> entry.getId() == m_answer.getId())
                .collect(Collectors.toList());
        return m_list.get(0);
    }

    public void create(TestAnswer m_answer) {
        TestAnswerList.add(m_answer);
    }

    public void update(TestAnswer m_answer) {

    }

    public void delete(TestAnswer m_answer) {
        TestAnswerList.removeIf(entry -> entry.getId() == m_answer.getId());
    }

    public void disconnect() {
    }
}
