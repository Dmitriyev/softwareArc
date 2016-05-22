package com.businesslogic.artifacts;

/**
Заявление
 */

public class Application {
    private long id;
    private String studentName;

    public Application(long id, String name) {
        this.studentName = name;
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.studentName;
    }
}
