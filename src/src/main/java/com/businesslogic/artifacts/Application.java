package com.businesslogic.artifacts;

/**
Заявление
 */

public class Application {
    private long id;
    private long student_id;
    private boolean registred;

    public Application(long student_id) {
        this.student_id = student_id;
    }

    public Application(long id, long student_id) {
        this.student_id = student_id;
        this.id = id;
    }

    public Application(long id, long student_id, boolean registred) {
        this.student_id = student_id;
        this.id = id;
        this.registred = registred;
    }

    public long getId() {
        return this.id;
    }

    public long getStudentId() {
        return this.student_id;
    }

    public void register() {
        this.registred = true;
    }

    public boolean getStatus() {
        return this.registred;
    }
}
