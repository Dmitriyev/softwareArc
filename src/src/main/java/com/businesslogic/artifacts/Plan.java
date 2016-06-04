package com.businesslogic.artifacts;

/**
Учебный план
 */
public class Plan {
    private long id;
    private long student_id;
    private String m_plan;
    private boolean validated;

    public Plan(long student_id, String m_plan, boolean validated) {
        this.student_id = student_id;
        this.m_plan = m_plan;
        this.validated = validated;
    }

    public Plan(long id, long student_id, String m_plan, boolean validated) {
        this.id = id;
        this.student_id = student_id;
        this.m_plan = m_plan;
        this.validated = validated;
    }

    public String getText() {
        return this.m_plan;
    }

    public long getId() {
        return this.id;
    }

    public void validate() {
        this.validated = true;
    }

    public long getStudentId() {
        return this.student_id;
    }

    public boolean isValidated() {
        return this.validated;
    }
}
