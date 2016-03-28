package BusinessLogic;

/**
 Кандидат на поступление
 */
public class Student {
    private String name;
    private Statement statement;
    private Mark mark;
    private Preferences preferences;

    public Student(String name) {
        this.name = name;
    }
}
