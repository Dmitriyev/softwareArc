package com.BusinessLogic;

/**
 �����
 */

public class HeadTeacher extends Person{
    public HeadTeacher(long id, String name) {
        super(id, name);
    }

    public void RegisterApplication(){
        //TODO: ����������� ���������
    }

    public TestTask createTestTask(long id, String text) {
        return new TestTask(id, text);
    }
}
