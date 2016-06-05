package com.businesslogic.artifacts;

import com.mappers.artifacts.MarkMapper;
import com.mappers.database.DataSourceGateway;

import java.io.IOException;
import java.sql.SQLException;

/**
Оценка за тест
 */

public class Mark {
    private long id;
    private long student_id;
    private int value;

    private static MarkMapper m_markMapper;

    public Mark (long student_id, int mark) throws SQLException, IOException {
        this.student_id = student_id;
        this.value = mark;
        m_markMapper = new MarkMapper(DataSourceGateway.getInstance().getDataSource());
        m_markMapper.insert(this);
    }

    public Mark (long id, long student_id, int mark) {
        this.id = id;
        this.student_id = student_id;
        this.value = mark;
    }

    public void delete() throws SQLException {
        m_markMapper.delete(this);
    }

    public int getValue() {
        return this.value;
    }

    public long getId() {
        return this.id;
    }

    public long getStudentId() {
        return this.student_id;
    }
}
