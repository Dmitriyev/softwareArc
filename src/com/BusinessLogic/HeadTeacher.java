package com.BusinessLogic;

/**
 Завуч
 */

public class HeadTeacher extends Person{
    public HeadTeacher(long id, String name) {
        super(id, name);
    }

    public void RegisterApplication(){
        //TODO: Регистрация заявления
    }

    public TestTask createTestTask(long id, String text) {
        return new TestTask(id, text);
    }
}
