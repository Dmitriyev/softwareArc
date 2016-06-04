package com.businesslogic.artifacts;

/**
Пожелание ученика касаемо личного учебного плана на текущий год
 */

public class Preferences {
    private long id;
    private long student_id;
    private String m_preferences;

    public Preferences(long student_id, String preferences) {
        this.student_id = student_id;
        this.m_preferences = preferences;
    }

    public Preferences(long id, long student_id, String preferences) {
        this.id = id;
        this.student_id = student_id;
        this.m_preferences = preferences;
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
