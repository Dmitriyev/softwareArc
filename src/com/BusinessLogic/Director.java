package com.BusinessLogic;

import java.util.Date;

/**
Директор
 */

public class Director extends Person{
    public Director() {

    }

    public Director(long id, String name) {
        super(id, name);
    }

    public void setTestTask(Test m_test, TestTask m_task) {
        m_test.setTask(m_task);
    }

    //TODO для всех поступающих
    public Interview createInterview(long id, Date m_date) {
        return new Interview(id, m_date);
    }

    //TODO отказать в одобрении
    public boolean validatePlan(Plan m_plan) {
        m_plan.validate();
        return true;
    }
}
