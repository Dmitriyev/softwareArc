package com.BusinessLogic;


import java.util.Date;
import java.util.List;

/**
Завуч
 */

public class HeadTeacher extends Person {
    public HeadTeacher(long id, String name) {
        super(id, name);
    }

    public void RegisterApplication(Application m_application) {
        //TODO Регистрация заявления
    }

    public TestTask createTestTask(long id, String text) {
        return new TestTask(id, text);
    }

    public Test createTest(long id, Date m_date) {
        return new Test(id, m_date);
    }

    public void setTestDate(Test m_test, Date m_date) {
        m_test.setDate(m_date);
    }

    //TODO: Проход по всем ученикам
    public void setMark(Student m_student, int m_mark) {
        m_student.setMark(new Mark(m_mark));
    }

    public TestTask getAnswer(Student m_student) {
        return m_student.getAnswer();
    }//

    //TODO Список допущенных
    public List<Student> getListOfAllowedStudents() {
        return null;
    }

    //TODO Выбор лучшего из худших
    public void getBestOfTheWorsts() {
    }

    //TODO Составить список поступивших
    public List<Student> getListOfIncomingStudents() {
        return null;
    }

    //TODO Все что дальше
    public Plan createPlan(String text) {
        return new Plan(text);
    }

    public void remakePlan(Plan m_plan, String text) {
        m_plan.setText(text);
    }
}


