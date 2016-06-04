package com.businesslogic.artifacts;

/**
Оценка за тест
 */

public class Mark {
    private long id;
    private long student_id;
    private int value;

    public Mark (long student_id, int mark) {
        this.student_id = student_id;
        this.value = mark;
    }

    public Mark (long id, long student_id, int mark) {
        this.id = id;
        this.student_id = student_id;
        this.value = mark;
    }

    public void setValue(int mark) {
        this.value = mark;
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
