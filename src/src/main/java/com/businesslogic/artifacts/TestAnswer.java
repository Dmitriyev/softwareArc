package com.businesslogic.artifacts;

import com.mappers.artifacts.TestAnswerMapper;
import com.mappers.database.DataSourceGateway;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Ответ поступающего на тестовое задание
 */

public class TestAnswer {
    private long id;
    private long student_id;
    private long task_id;
    private String answerText;

    private static TestAnswerMapper m_testAnswerMapper;

    public TestAnswer(long student_id, long task_id, String answerText) throws SQLException, IOException{
        this.student_id = student_id;
        this.task_id = task_id;
        this.answerText = answerText;
        m_testAnswerMapper = new TestAnswerMapper(DataSourceGateway.getInstance().getDataSource());
        m_testAnswerMapper.insert(this);
    }

    public TestAnswer(long id, long student_id, long task_id, String answerText) {
        this.id = id;
        this.student_id = student_id;
        this.task_id = task_id;
        this.answerText = answerText;
    }

    public void delete() throws SQLException {
        m_testAnswerMapper.delete(this);
    }

    public long getId() {
        return this.id;
    }

    public String getText() {
        return this.answerText;
    }

    public long getStudentId() {
        return this.student_id;
    }

    public long getTaskId() {
        return this.task_id;
    }
}
