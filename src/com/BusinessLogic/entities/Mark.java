package com.BusinessLogic.entities;

/**
Оценка за тест
 */

public class Mark {
    private int value;

    public Mark (int mark) {
        this.value = mark;
    }

    public int getValue() {
        return this.value;
    }
}
