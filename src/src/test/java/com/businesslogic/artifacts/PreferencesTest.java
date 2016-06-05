package com.businesslogic.artifacts;

import com.repositories.artifacts.PreferencesRepository;
import org.junit.*;

import java.sql.SQLException;

/**
 * Created by pitochka on 05.06.16.
 */
public class PreferencesTest {
    private static PreferencesRepository m_repository;

    @BeforeClass
    public static void setUp() throws Exception {
        m_repository = new PreferencesRepository();
    }

    @Test
    public void testGetting() throws Exception, SQLException {
        Preferences m_preferences = m_repository.getAll().get(0);
        assert m_preferences.getStudentId() == 12;
        assert m_preferences.getText().equals("test preferences");
    }

    @AfterClass
    public static void testDelete() throws Exception, SQLException {
        m_repository.getAll().get(0).delete();
        m_repository.delete(m_repository.getAll().get(0));
        m_repository.disconnect();
    }
}
