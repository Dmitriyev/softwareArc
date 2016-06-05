package com.businesslogic.artifacts;

import com.repositories.artifacts.TestAnswerRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by pitochka on 05.06.16.
 */
public class TestAnswerTest {
    private static TestAnswerRepository m_repository;

    @Before
    public void setUp() throws Exception {
        m_repository = new TestAnswerRepository();
    }

    @Test
    public void testGetting() throws Exception, SQLException {
        TestAnswer m_answer = m_repository.getAll().get(0);
        assert m_answer.getStudentId() == 12;
        assert m_answer.getTaskId() == 2;
        assert m_answer.getText().equals("test answer");
    }


    @Test
    public void testUpdating() throws Exception, SQLException {
        TestAnswer m_answer = m_repository.getAll().get(0);
        m_answer.setAnswer("new test answer");
        m_repository.update(m_answer);
        assert m_repository.getAll().get(0).getText().equals("new test answer");
    }

    @After
    public void testDelete() throws Exception, SQLException {
        m_repository.delete(m_repository.getAll().get(0));
        m_repository.disconnect();
    }
}
