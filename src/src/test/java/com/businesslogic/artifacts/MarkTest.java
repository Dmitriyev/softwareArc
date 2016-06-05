package com.businesslogic.artifacts;

import com.repositories.artifacts.MarkRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by pitochka on 05.06.16.
 */
public class MarkTest {
    private static MarkRepository m_repository;

    @Before
    public void setUp() throws Exception {
        m_repository = new MarkRepository();
    }

    @Test
    public void testGetting() throws Exception {
        Mark m_mark = m_repository.getAll().get(0);
        m_repository.update(m_mark);
        assert m_mark.getStudentId() == 12;
        assert m_mark.getValue() == 3;
    }


    @Test
    public void testUpdating() throws Exception {
        Mark m_mark = m_repository.getAll().get(0);
        m_mark.setValue(4);
        m_repository.update(m_mark);
        assert m_repository.getAll().get(0).getValue() == 4;
    }

    @After
    public void testDelete() throws Exception {
        m_repository.delete(m_repository.getAll().get(0));
        m_repository.disconnect();
    }
}
