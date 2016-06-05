package com.events;

import com.repositories.artifacts.TestTaskRepository;
import com.repositories.events.TestRepository;
import org.junit.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by pitochka on 05.06.16.
 */
public class TestTest {
    private static TestRepository m_repository;
    private static TestTaskRepository m_testTaskRepository;

    @BeforeClass
    public static void setUp() throws Exception {
        m_repository = new TestRepository();
        m_testTaskRepository = new TestTaskRepository();
    }

    @Test
    public void testGetting() throws Exception {
        com.businesslogic.events.Test m_test = m_repository.getAll().get(0);
        Calendar date = new GregorianCalendar(2016, 06, 05);
        assert m_test.getDate().equals(date.getTime());
    }


    @Test
    public void testUpdating() throws Exception {
        com.businesslogic.events.Test m_test = m_repository.getAll().get(0);
        m_test.setTask(m_testTaskRepository.getAll().get(0));
        assert m_test.getTask().getTestId() == m_test.getId();

    }

    @AfterClass
    public static void testDelete() throws Exception {
        m_repository.getAll().get(0).deleteByDate();
        m_repository.delete(m_repository.getAll().get(0));
        m_repository.disconnect();
        m_testTaskRepository.getAll().get(0).delete();
        m_testTaskRepository.delete(m_testTaskRepository.getAll().get(0));
        m_testTaskRepository.disconnect();
    }
}
