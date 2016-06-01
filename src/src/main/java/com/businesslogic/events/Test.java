package com.businesslogic.events;

import com.businesslogic.artifacts.TestTask;

import java.util.Date;

/**
Тестирование
 */

public class Test extends Event {
    private TestTask m_task;

    public Test(Date m_date) {
        super(m_date);
    }

    public Test(long id, Date m_date) {
        super(id, m_date);
    }

    public Test(long id, Date m_date, TestTask m_task) {
        super(id, m_date);
        this.m_task = m_task;
    }

    public void setTask(TestTask m_task) {
        this.m_task = m_task;
    }

    public TestTask getTask() {
        return this.m_task;
    }
}
