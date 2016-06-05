package com.businesslogic.artifacts;

import com.repositories.artifacts.TestAnswerRepository;
import com.repositories.artifacts.TestTaskRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by pitochka on 05.06.16.
 */
public class TestTaskTest {
    private static TestTaskRepository m_repository;

    @Before
    public void setUp() throws Exception {
        m_repository = new TestTaskRepository();
    }

    @Test
    public void testGetting() throws Exception, SQLException {
        TestTask m_task = m_repository.getAll().get(0);
        assert m_task.getText().equals("test task");
    }


    @Test
    public void testUpdating() throws Exception, SQLException {
        TestTask m_task = m_repository.getAll().get(0);
        m_task.setTaskText("new test task");
        m_task.setTestId(3);
        m_repository.update(m_task);
        assert m_repository.getAll().get(0).getText().equals("new test task");
        assert m_repository.getAll().get(0).getTestId() == 3;

    }

    @After
    public void testDelete() throws Exception, SQLException {
        m_repository.delete(m_repository.getAll().get(0));
        m_repository.disconnect();
    }
}
