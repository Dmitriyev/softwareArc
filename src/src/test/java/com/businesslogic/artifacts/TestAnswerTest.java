package com.businesslogic.artifacts;

import com.repositories.artifacts.TestAnswerRepository;
import org.junit.*;

/**
 * Created by pitochka on 05.06.16.
 */
public class TestAnswerTest {
    private static TestAnswerRepository m_repository;

    @BeforeClass
    public static void setUp() throws Exception {
        m_repository = new TestAnswerRepository();
    }

    @Test
    public void testGetting() throws Exception {
        TestAnswer m_answer = m_repository.getAll().get(0);
        assert m_answer.getStudentId() == 12;
        assert m_answer.getTaskId() == 2;
        assert m_answer.getText().equals("test answer");
    }

    @AfterClass
    public static void testDelete() throws Exception {
        m_repository.getAll().get(0).delete();
        m_repository.delete(m_repository.getAll().get(0));
        m_repository.disconnect();
    }
}
