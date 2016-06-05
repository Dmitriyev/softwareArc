package com.businesslogic.artifacts;

import com.mappers.artifacts.PlanMapper;
import com.mappers.database.DataSourceGateway;

import java.io.IOException;
import java.sql.SQLException;

/**
Учебный план
 */
public class Plan {
    private long id;
    private long student_id;
    private String m_plan;
    private boolean validated;

    private static PlanMapper m_planMapper;

    public Plan(long student_id, String m_plan, boolean validated) throws SQLException, IOException{
        this.student_id = student_id;
        this.m_plan = m_plan;
        this.validated = validated;
        m_planMapper = new PlanMapper(DataSourceGateway.getInstance().getDataSource());
        m_planMapper.insert(this);
    }

    public Plan(long id, long student_id, String m_plan, boolean validated) {
        this.id = id;
        this.student_id = student_id;
        this.m_plan = m_plan;
        this.validated = validated;
    }

    public void delete() throws SQLException {
        m_planMapper.delete(this);
    }

    public void setText(String text) throws SQLException {
        this.m_plan = text;
        m_planMapper.update(this);
    }

    public void validate() throws SQLException{
        this.validated = true;
        m_planMapper.update(this);
    }

    public String getText() {
        return this.m_plan;
    }

    public long getId() {
        return this.id;
    }

    public long getStudentId() {
        return this.student_id;
    }

    public boolean isValidated() {
        return this.validated;
    }

    public void setStatus(boolean status) {
        this.validated = status;
    }
}
