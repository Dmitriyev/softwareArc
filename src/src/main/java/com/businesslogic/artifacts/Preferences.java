package com.businesslogic.artifacts;

import com.mappers.artifacts.PreferencesMapper;
import com.mappers.database.DataSourceGateway;

import java.io.IOException;
import java.sql.SQLException;

/**
Пожелание ученика касаемо личного учебного плана на текущий год
 */

public class Preferences {
    private long id;
    private long student_id;
    private String m_preferences;

    private static PreferencesMapper m_preferencesMapper;

    public Preferences(long student_id, String preferences) throws SQLException, IOException{
        this.student_id = student_id;
        this.m_preferences = preferences;
        m_preferencesMapper = new PreferencesMapper(DataSourceGateway.getInstance().getDataSource());
        m_preferencesMapper.insert(this);
    }

    public Preferences(long id, long student_id, String preferences) {
        this.id = id;
        this.student_id = student_id;
        this.m_preferences = preferences;
    }

    public void delete() throws SQLException {
        m_preferencesMapper.delete(this);
    }

    public String getText() {
        return this.m_preferences;
    }

    public long getId() {
        return this.id;
    }

    public long getStudentId() {
        return this.student_id;
    }
}
