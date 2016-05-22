package com.businesslogic.artifacts;

/**
Заявление
 */

public class Application {
    private long id;
    private String studentName;
    private boolean registred = false;

    public Application(long id, String name) {
        this.studentName = name;
        this.id = id;
    }

    public Application(String name) {
        this.studentName = name;
    }

    public Application(long id, String name, boolean registred) {
        this.id = id;
        this.studentName = name;
        this.registred = registred;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.studentName;
    }

    public void register() {
        this.registred = true;
    }

    public boolean getStatus() {
        return this.registred;
    }
}
