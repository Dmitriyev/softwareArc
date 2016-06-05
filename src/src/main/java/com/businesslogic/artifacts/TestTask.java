package com.businesslogic.artifacts;

/**
 Тестовое задание
 */

public class TestTask {
    private long id;
    private long test_id;
    private String taskText;

    public TestTask (String text) {
        this.taskText = text;
    }

    public TestTask (long id, long test_id, String text) {
        this.id = id;
        this.test_id = test_id;
        this.taskText = text;
    }

    public void setTestId(long id) {
        this.test_id = id;
    }

    public void setTaskText(String text) {
        this.taskText = text;
    }

    public long getId() {
        return this.id;
    }

    public String getText() {
        return this.taskText;
    }

    public long getTestId() {
        return this.test_id;
    }
}
