package com.BusinessLogic;

/**
Заявление на поступление
 */

public class Application {
//    private static long currentID = 0;
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
        return  this.studentName;
    }
}
