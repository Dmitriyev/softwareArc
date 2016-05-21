package com.BusinessLogic;

/**
 Ученик
 */

public class Student extends Person {
    private Application m_application;
    private TestTask m_task;
    private Mark m_mark;

    public Student(long id, String name) {
        super(id, name);
    }

    public Application createApplication(long id) {
        m_application = new Application(id, this.getName());
        return m_application;
    }

    public Application getApplication() {
        return this.m_application;
    }

    public void getTestTask(Test m_test) {
        this.m_task = m_test.getTask();
    }

    public void setAnswer(String answer) {
        this.m_task.setAnswer(answer);
    }

    public TestTask getAnswer() {
        return this.m_task;
    }

    public void setMark(Mark m_mark) {
        this.m_mark = m_mark;
    }

    public void CreatePreferences(Interview m_interview, String m_preferences) {
        m_interview.setPreferences(new Preferences(m_preferences));
    }
}
