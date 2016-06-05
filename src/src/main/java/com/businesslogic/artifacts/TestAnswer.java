package com.businesslogic.artifacts;

/**
 * Ответ поступающего на тестовое задание
 */

public class TestAnswer {
    private long id;
    private long student_id;
    private long task_id;
    private String answerText;

    public TestAnswer(long student_id, long task_id, String answerText) {
        this.student_id = student_id;
        this.task_id = task_id;
        this.answerText = answerText;
    }

    public TestAnswer(long id, long student_id, long task_id, String answerText) {
        this.id = id;
        this.student_id = student_id;
        this.task_id = task_id;
        this.answerText = answerText;
    }

    public long getId() {
        return this.id;
    }

    public String getText() {
        return this.answerText;
    }

    public long getStudentId() {
        return this.student_id;
    }

    public long getTaskId() {
        return this.task_id;
    }

    public void setAnswer(String text) {
        this.answerText = text;
    }
}
