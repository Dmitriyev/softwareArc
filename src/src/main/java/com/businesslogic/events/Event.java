package com.businesslogic.events;

import java.util.Date;

/**
 * Событие (Тестирование, собеседование)
 */
public class Event {
    private long id;
    private Date m_date;

    public Event() {

    }

    public Event(long id) {
        this.id  = id;
    }

    public Event(Date m_date) {
        this.m_date  = m_date;
    }

    public Event(long id, Date m_date) {
        this.id = id;
        this.m_date = m_date;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setDate(Date m_date) {
        this.m_date = m_date;
    }


    public Date getDate() {
        return this.m_date;
    }
}
