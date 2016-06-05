package com.businesslogic.artifacts;

import com.mappers.artifacts.TestAnswerMapper;
import com.mappers.artifacts.TestTaskMapper;
import com.mappers.database.DataSourceGateway;

import java.io.IOException;
import java.sql.SQLException;

/**
 Тестовое задание
 */

public class TestTask {
    private long id;
    private long test_id;
    private String taskText;

    private static TestTaskMapper m_testTaskMapper;

    public TestTask (String text) throws SQLException, IOException {
        this.taskText = text;
        m_testTaskMapper = new TestTaskMapper(DataSourceGateway.getInstance().getDataSource());
        m_testTaskMapper.insert(this);
    }

    public TestTask (long id, long test_id, String text) {
        this.id = id;
        this.test_id = test_id;
        this.taskText = text;
    }

    public void setTaskText(String text) throws SQLException {
        this.taskText = text;
        m_testTaskMapper.update(this);
    }

    public void setTestId(long id) throws SQLException {
        this.test_id = id;
        m_testTaskMapper.update(this);
    }

    public void delete() throws SQLException {
        m_testTaskMapper.delete(this);
    }

    public long getId() {
        return this.id;
    }

    public String getText() {
        return this.taskText;
    }

    public long getTestId() {
        return this.test_id;
    }
}
