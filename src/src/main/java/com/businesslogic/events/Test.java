package com.businesslogic.events;

import com.businesslogic.artifacts.TestTask;
import com.mappers.database.DataSourceGateway;
import com.mappers.events.TestMapper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

/**
Тестирование
 */

public class Test extends Event {
    private TestTask m_task;

    private static TestMapper m_testMapper;

    public Test(Date m_date) throws SQLException, IOException{
        super(m_date);
        m_testMapper = new TestMapper(DataSourceGateway.getInstance().getDataSource());
        m_testMapper.insert(this);
    }

    public Test(long id, Date m_date) {
        super(id, m_date);
    }

    public Test(long id, Date m_date, TestTask m_task) {
        super(id, m_date);
        this.m_task = m_task;
    }

    public void setTask(TestTask m_task) throws SQLException {
        this.m_task = m_task;
        m_task.setTestId(this.getId());
        m_testMapper.update(this);
    }

    public void deleteByDate() throws SQLException {
        m_testMapper.deleteByDate(this);
    }

    public TestTask getTask() {
        return this.m_task;
    }
}
