package com.BusinessLogic;

/**
 Тестовое задание
 */

public class TestTask {
    private long id;
    private String taskText;
    private String taskAnswer;

    public TestTask (long id, String text) {
        this.id = id;
        this.taskText = text;
    }

    public long getId() {
        return this.id;
    }

    public String getText() {
        return this.taskText;
    }

    public void setAnswer(String answer) {
        this.taskAnswer = answer;
    }

    public String getAnswer() {
        return this.taskAnswer;
    }


}
