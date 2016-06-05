package com.repositories.artifacts;

import com.businesslogic.artifacts.Application;
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

    public ApplicationRepository() throws SQLException, IOException{
        ApplicationList = new ArrayList<Application>();
        ApplicationList.add(new Application(12, false));
    }

    public ApplicationRepository(DataSource dataSource) {
        ApplicationList = new ArrayList<Application>();
    }

    public List<Application> getAll() {
        return this.ApplicationList;
    }

    public Application get(Application m_application) {
        List<Application> m_list = ApplicationList.stream()
                .filter(entry -> entry.getId() == m_application.getId())
                .collect(Collectors.toList());
        return m_list.get(0);
    }

    public void create(Application m_application) {
        ApplicationList.add(m_application);
    }

    public void update(Application m_application) {
        ApplicationList.stream()
                .filter(entry -> entry.getId() == m_application.getId())
                .forEach(entry ->
                        entry.setStatus(m_application.getStatus()));
    }

    public void delete(Application m_application) {
        ApplicationList.removeIf(entry -> entry.getId() == m_application.getId());
    }

    public void disconnect() {
    }
}
