package com.businesslogic.entities;

import com.businesslogic.artifacts.*;
import com.businesslogic.events.Interview;
import com.businesslogic.events.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 Ученик
 */

public class Student extends Person {
    private Application m_application;
    private TestAnswer m_answer;
    private Mark m_mark;
    private boolean allowedToInterview;
    private Preferences m_preferences;
    private Plan m_plan;

    public Student(String name) {
        super(name);
    }

    public Student(long id, String name) {
        super(id, name);
    }

    public Application createApplication() throws SQLException, IOException{
        m_application = new Application(this.getId(), false);
        return m_application;
    }

    public void setApplication(Application m_application) {
        this.m_application = m_application;
    }

    public Application getApplicationId() {
        return this.m_application;
    }

    public TestAnswer createAnswer(String text, long task_id) throws SQLException, IOException{
        m_answer = new TestAnswer(this.getId(), task_id, text);
        return m_answer;
    }

    public void setAnswer(TestAnswer m_answer) {
        this.m_answer = m_answer;
    }

    public TestAnswer getAnswer() {
        return this.m_answer;
    }

    public void setMark(Mark m_mark) {
        this.m_mark = m_mark;
    }

    public Mark getMark() {
        return this.m_mark;
    }

    public void allowToInterview() {
        allowedToInterview = true;
    }

    public boolean isAllowedToInterview() {
        return this.allowedToInterview;
    }

    public Preferences CreatePreferences(String text) throws SQLException, IOException{
        m_preferences = new Preferences(this.getId(), text);
        return m_preferences;
    }

    public void setPreferences(Preferences m_preferences) {
        this.m_preferences = m_preferences;
    }

    public Preferences getPreferences() {
        return this.m_preferences;
    }

    public void setPlan(Plan m_plan) {
        this.m_plan = m_plan;
    }

    public Plan getPlan() {
        return this.m_plan;
    }
}
