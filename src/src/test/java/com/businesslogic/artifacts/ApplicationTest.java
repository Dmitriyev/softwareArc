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
import java.util.Map;
public class ApplicationTest {
    private static DataSourceGateway m_dataSourceGateway;
    private static ApplicationMapper m_applicationMapper;
    private static Application m_application;

    @Before
    public void setUp() throws Exception {
        m_dataSourceGateway = DataSourceGateway.getInstance();
        m_applicationMapper = new ApplicationMapper(m_dataSourceGateway.getDataSource());
        m_application = new Application("Vasiliy Ivanov");
    }

    @Test
    public void testRegister() throws Exception {
        m_application.register();
        assert m_application.getStatus() == true;
    }

    @Test
    public void testInsert() throws Exception {
        m_applicationMapper.insert(m_application);
        Application tmp = m_applicationMapper.findAll().get(0);
        assert tmp.getName().equals("Vasiliy Ivanov");
    }
}
