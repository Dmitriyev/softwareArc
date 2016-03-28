package BusinessLogic;

import java.util.Random;

/**
Заявление ученика на поступление
 */
public class Statement {
    private int id;
    private String studentName;

    public Statement(String studentName) {
        this.studentName = studentName;
    }

    public void registerStatment() {
        this.id = this.generateId();
    }

    private int generateId() {
        Random rn = new Random();
        return rn.nextInt();
    }

    public int getId() {
        return this.id;
    }
}
