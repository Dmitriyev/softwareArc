package com.businesslogic.events;

import java.util.Date;

/**
Собеседование
 */

public class Interview extends Event{
    private long student_id;
    private String interviewerComments;

    public Interview(long student_id, Date m_date) {
        super(m_date);
        this.student_id = student_id;
    }

    public Interview(long id, long student_id, Date m_date) {
        super(id, m_date);
        this.student_id = student_id;
    }

    public Interview(long id, long student_id, Date m_date, String interviewerComments) {
        super(id, m_date);
        this.student_id = student_id;
        this.interviewerComments = interviewerComments;
    }

    public void setComments(String interviewerComments) {
        this.interviewerComments = interviewerComments;
    }

    public String getComments() {
        return this.interviewerComments;
    }
}
