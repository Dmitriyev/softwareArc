package com.repositories.artifacts;

import com.businesslogic.artifacts.Application;
import com.mappers.artifacts.ApplicationMapper;
import com.mappers.database.DataSourceGateway;
import com.repositories.Repository;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pitochka on 05.06.16.
 */
public class ApplicationRepository implements Repository<Application> {
    private static List<Application> ApplicationList;
    private static ApplicationMapper m_applicationMapper;

    public ApplicationRepository() throws SQLException, IOException {
        ApplicationList = new ArrayList<Application>();
        DataSourceGateway gateway = DataSourceGateway.getInstance();
        m_applicationMapper = new ApplicationMapper(DataSourceGateway.getDataSource());
        ApplicationList.add(new Application(12, false));
    }

    public ApplicationRepository(DataSource dataSource) throws SQLException {
        ApplicationList = new ArrayList<Application>();
        m_applicationMapper = new ApplicationMapper(dataSource);
    }

    public List<Application> getAll() {
        return this.ApplicationList;
    }

    public Application get(Application m_application) throws SQLException{
        List<Application> m_list = ApplicationList.stream()
                .filter(entry -> entry.getId() == m_application.getId())
                .collect(Collectors.toList());
        if (m_list.isEmpty()) {
            Application application = m_applicationMapper.find(m_application.getId());
            m_list.add(application);
            return application;
        }
        return m_list.get(0);
    }

    public void create(Application m_application) throws SQLException {
        ApplicationList.add(m_application);
        m_applicationMapper.insert(m_application);
    }

    public void update(Application m_application) throws SQLException{
        ApplicationList.stream()
                .filter(entry -> entry.getId() == m_application.getId())
                .forEach(entry ->
                    entry.setStatus(m_application.getStatus()));
        m_applicationMapper.update(m_application);
    }

    public void delete(Application m_application) throws SQLException {
        ApplicationList.removeIf(entry -> entry.getId() == m_application.getId());
        m_applicationMapper.delete(m_application);
    }

    public void disconnect() throws SQLException {
        m_applicationMapper.closeConnection();
    }
}
