package com.BusinessLogic;

/**
 �������� �� �����������
 */

public class Student extends Person {
    private Application m_application;

    public Student(long id, String name) {
        super(id, name);
    }

    public void createApplication(long id) {
        m_application = new Application(id, this.getName());
    }

    public Application getApplication() {
        return this.m_application;
    }
}
