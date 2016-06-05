package com.businesslogic.artifacts;

import com.repositories.artifacts.PlanRepository;
import org.junit.*;

import java.sql.SQLException;

/**
 * Created by pitochka on 05.06.16.
 */
public class PlanTest {
    private static PlanRepository m_repository;

    @BeforeClass
    public static void setUp() throws Exception {
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
        m_plan.setText("new test plan");
        assert m_repository.getAll().get(0).isValidated();
        assert m_plan.getText().equals("new test plan");
    }

    @AfterClass
    public static void testDelete() throws Exception, SQLException {
        m_repository.getAll().get(0).delete();
        m_repository.delete(m_repository.getAll().get(0));
        m_repository.disconnect();
    }
}
