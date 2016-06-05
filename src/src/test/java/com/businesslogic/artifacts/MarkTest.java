package com.businesslogic.artifacts;

import com.repositories.artifacts.MarkRepository;
import org.junit.*;

import java.sql.SQLException;

/**
 * Created by pitochka on 05.06.16.
 */
public class MarkTest {
    private static MarkRepository m_repository;

    @BeforeClass
    public static void setUp() throws Exception {
        m_repository = new MarkRepository();
    }

    @Test
    public void testGetting() throws Exception {
        Mark m_mark = m_repository.getAll().get(0);
        assert m_mark.getStudentId() == 12;
        assert m_mark.getValue() == 3;
    }

    @AfterClass
    public static void testDelete() throws Exception {
        m_repository.getAll().get(0).delete();
        m_repository.delete(m_repository.getAll().get(0));
        m_repository.disconnect();
    }
}
