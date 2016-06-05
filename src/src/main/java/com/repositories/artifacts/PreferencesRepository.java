package com.repositories.artifacts;

import com.businesslogic.artifacts.Preferences;
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

        public PreferencesRepository() throws SQLException, IOException{
            PreferencesList = new ArrayList<Preferences>();
            PreferencesList.add(new Preferences(12, "test preferences"));
        }

        public PreferencesRepository(DataSource dataSource) {
            PreferencesList = new ArrayList<Preferences>();
        }

        public List<Preferences> getAll() {
            return this.PreferencesList;
        }

        public Preferences get(Preferences m_preferences) {
            List<Preferences> m_list = PreferencesList.stream()
                    .filter(entry -> entry.getId() == m_preferences.getId())
                    .collect(Collectors.toList());
             return m_list.get(0);
        }

        public void create(Preferences m_preferences) {
            PreferencesList.add(m_preferences);
        }

        public void update(Preferences m_preferences) {

        }

        public void delete(Preferences m_preferences) {
            PreferencesList.removeIf(entry -> entry.getId() == m_preferences.getId());
        }

        public void disconnect() {
        }
}
