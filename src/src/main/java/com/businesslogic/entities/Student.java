package com.businesslogic.entities;

import com.businesslogic.artifacts.Application;
import com.businesslogic.artifacts.Mark;
import com.businesslogic.artifacts.Preferences;
import com.businesslogic.artifacts.TestTask;
import com.businesslogic.events.Interview;
import com.businesslogic.events.Test;

/**
 Ученик
 */

public class Student extends Person {
    private long applicationId;
    private long taskId;
    private Mark m_mark;

    public Student(long id, String name) {
        super(id, name);
    }

    public Application createApplication(long id) {
        this.applicationId = id;
        Application m_application = new Application(this.applicationId, this.getName());
        return m_application;
    }

    public long getApplicationId() {
        return this.applicationId;
    }

    public void getTestTask(Test m_test) {
        this.taskId = m_test.getTask().getId();
    }

    public void setAnswer(TestTask m_task, String answer) {
        m_task.setAnswer(answer);
    }

    public long getTaskId() {
        return this.taskId;
    }

    public void setMark(Mark m_mark) {
        this.m_mark = m_mark;
    }

    public Mark getMark() {
        return this.m_mark;
    }

    public void CreatePreferences(Interview m_interview, String m_preferences) {
        m_interview.setPreferences(new Preferences(m_preferences));
    }
}
