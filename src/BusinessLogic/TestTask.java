package BusinessLogic;

import java.io.File;
import java.io.IOException;

/**
 Тестовое задание
 */
public class TestTask {
    private String TaskFileName;

    public TestTask(String TaskFileName) {
        File file = new File(TaskFileName);
        if (!file.exists()) {
            // TODO не создавать объект класса
        }
    }
}
