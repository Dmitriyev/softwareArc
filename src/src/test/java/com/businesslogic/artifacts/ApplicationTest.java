package com.businesslogic.artifacts;

/**
 * Created by pitochka on 22.05.16.
 */
import com.mappers.artifacts.ApplicationMapper;
import com.mappers.database.DataSourceGateway;
import com.repositories.artifacts.ApplicationRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class ApplicationTest {
    private static ApplicationRepository m_repository;

    @Before
    public void setUp() throws Exception {
        m_repository = new ApplicationRepository();
    }

    @Test
    public void testGetting() throws Exception, SQLException {
        Application m_application = m_repository.getAll().get(0);
        assert m_application.getStudentId() == 12;
        assert !m_application.getStatus();
    }


    @Test
    public void testUpdating() throws Exception, SQLException {
        Application m_application = m_repository.getAll().get(0);
        m_application.register();
        m_repository.update(m_application);
        assert m_repository.getAll().get(0).getStatus();
    }

    @After
    public void testDelete() throws Exception, SQLException {
        m_repository.delete(m_repository.getAll().get(0));
    }
}
