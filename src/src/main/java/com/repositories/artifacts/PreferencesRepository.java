package com.repositories.artifacts;

import com.businesslogic.artifacts.Preferences;
import com.mappers.artifacts.PreferencesMapper;
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
public class PreferencesRepository implements Repository<Preferences> {
        private static List<Preferences> PreferencesList;
        private static PreferencesMapper m_preferencesMapper;

        public PreferencesRepository() throws SQLException, IOException {
            PreferencesList = new ArrayList<Preferences>();
            DataSourceGateway gateway = DataSourceGateway.getInstance();
            m_preferencesMapper = new PreferencesMapper(DataSourceGateway.getDataSource());
            PreferencesList.add(new Preferences(12, "test preferences"));
        }

        public PreferencesRepository(DataSource dataSource) throws SQLException {
            PreferencesList = new ArrayList<Preferences>();
            m_preferencesMapper = new PreferencesMapper(dataSource);
        }

        public List<Preferences> getAll() {
            return this.PreferencesList;
        }

        public Preferences get(Preferences m_preferences) throws SQLException{
            List<Preferences> m_list = PreferencesList.stream()
                    .filter(entry -> entry.getId() == m_preferences.getId())
                    .collect(Collectors.toList());
            if (m_list.isEmpty()) {
                Preferences preferences = m_preferencesMapper.find(m_preferences.getId());
                m_list.add(preferences);
                return preferences;
            }
            return m_list.get(0);
        }

        public void create(Preferences m_preferences) throws SQLException {
            PreferencesList.add(m_preferences);
            m_preferencesMapper.insert(m_preferences);
        }

        public void update(Preferences m_preferences) throws SQLException{

        }

        public void delete(Preferences m_preferences) throws SQLException {
            PreferencesList.removeIf(entry -> entry.getId() == m_preferences.getId());
            m_preferencesMapper.delete(m_preferences);
        }

        public void disconnect() throws SQLException {
            m_preferencesMapper.closeConnection();
        }
}
