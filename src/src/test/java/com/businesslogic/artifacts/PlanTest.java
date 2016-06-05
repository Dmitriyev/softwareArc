package com.businesslogic.artifacts;

import com.repositories.artifacts.PlanRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by pitochka on 05.06.16.
 */
public class PlanTest {
    private static PlanRepository m_repository;

    @Before
    public void setUp() throws Exception {
        m_repository = new PlanRepository();
    }

    @Test
    public void testGetting() throws Exception, SQLException {
        Plan m_plan = m_repository.getAll().get(0);
        assert m_plan.getStudentId() == 12;
        assert m_plan.getText().equals("test plan");
        assert !m_plan.isValidated();
    }


    @Test
    public void testUpdating() throws Exception, SQLException {
        Plan m_plan = m_repository.getAll().get(0);
        m_plan.validate();
        m_repository.update(m_plan);
        assert m_repository.getAll().get(0).isValidated();
    }

    @After
    public void testDelete() throws Exception, SQLException {
        m_repository.delete(m_repository.getAll().get(0));
        m_repository.disconnect();
    }
}
