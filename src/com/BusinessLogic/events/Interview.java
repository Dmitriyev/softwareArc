package com.businesslogic.events;

import com.businesslogic.entities.Preferences;

import java.util.Date;

/**
Собеседование
 */

public class Interview extends Event{
    Preferences m_preferences;

    public Interview(long id, Date m_date) {
        super(id, m_date);
    }

    public void setPreferences(Preferences m_preferences) {
        this.m_preferences = m_preferences;
    }

    public Preferences getM_preferences() {
        return this.m_preferences;
    }
}
