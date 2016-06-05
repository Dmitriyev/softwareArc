package com.businesslogic.artifacts;

/**
 * Created by pitochka on 22.05.16.
 */
import com.repositories.artifacts.ApplicationRepository;
import org.junit.*;

import java.sql.SQLException;
import java.util.List;

public class ApplicationTest {
    private static ApplicationRepository m_repository;

    @BeforeClass
    public static void setUp() throws Exception {
        m_repository = new ApplicationRepository();
    }

    @Test
    public void testGetting() throws Exception {
        Application m_application = m_repository.getAll().get(0);
        assert m_application.getStudentId() == 12;
        assert !m_application.getStatus();
    }


    @Test
    public void testUpdating() throws Exception {
        Application m_application = m_repository.getAll().get(0);
        m_application.register();
        assert m_repository.getAll().get(0).getStatus();
    }

    @AfterClass
    public static void testDelete() throws Exception {
        m_repository.getAll().get(0).delete();
        m_repository.delete(m_repository.getAll().get(0));
        m_repository.disconnect();
    }
}
