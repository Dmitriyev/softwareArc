package com.businesslogic.artifacts;

/**
 * Created by pitochka on 22.05.16.
 */
import com.mappers.artifacts.ApplicationMapper;
import com.mappers.database.DataSourceGateway;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
public class ApplicationTest {
    private static DataSourceGateway m_dataSourceGateway;
    private static ApplicationMapper m_applicationMapper;
    private static Application m_application;
    private static long id;

    @Before
    public void setUp() throws Exception {
        m_dataSourceGateway = DataSourceGateway.getInstance();
        m_applicationMapper = new ApplicationMapper(m_dataSourceGateway.getDataSource());
        m_application = new Application("Vasiliy Ivanov");
    }

    @Test
    public void testInsert() throws Exception {
        m_applicationMapper.insert(m_application);
        Application tmp = m_applicationMapper.findAll().get(0);
        id = tmp.getId();
        assert tmp.getName().equals("Vasiliy Ivanov");
    }


    @Test
    public void testRegister() throws Exception {
        m_application = m_applicationMapper.findAll().get(0);
        id = m_application.getId();
        m_application.register();
        m_applicationMapper.update(m_application);
        Application tmp = m_applicationMapper.find(id);
        assert tmp.getStatus();
    }

    @Test public void testDelete() throws Exception {
        m_applicationMapper.delete(id);
        boolean failed = false;
        List<Application> all = m_applicationMapper.findAll();
        for (Application i : all) {
            if (i.getId() == id)
                failed = true;
        }
        assert !failed;
    }
}
