package com.BusinessLogic.entities;

import java.util.Date;

/**
Тестирование
 */

public class Test extends Event {
    private TestTask m_task;

    public Test() {

    }

    public Test(long id) {
        super(id);
    }

    public Test(long id, Date m_date) {
        super(id, m_date);
    }

    public void setTask(TestTask m_task) {
        this.m_task = m_task;
    }

    public TestTask getTask() {
        return this.m_task;
    }
}
