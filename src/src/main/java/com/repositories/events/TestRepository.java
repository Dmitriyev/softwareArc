package com.repositories.events;

import com.businesslogic.events.Test;
import com.repositories.Repository;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by pitochka on 05.06.16.
 */
public class TestRepository implements Repository<Test> {
    private static List<Test> TestList;

    public TestRepository() throws SQLException, IOException {
        TestList = new ArrayList<Test>();
        Calendar date = new GregorianCalendar(2016, 06, 05);
        Test test = new Test(date.getTime());
        TestList.add(test);
    }

    public TestRepository(DataSource dataSource) {
        TestList = new ArrayList<Test>();
    }

    public List<Test> getAll() {
        return this.TestList;
    }

    public Test get(Test m_test) {
        List<Test> m_list = TestList.stream()
                .filter(entry -> entry.getId() == m_test.getId())
                .collect(Collectors.toList());
        return m_list.get(0);
    }

    public void create(Test m_test) {
        TestList.add(m_test);
    }

    public void update(Test m_test) {
//        TestTaskList.stream()
//                .filter(entry -> entry.getId() == m_task.getId())
//                .forEach(entry ->
//                        entry.setTaskText(m_task.getText()));
    }

    public void delete(Test m_test) {
        TestList.removeIf(entry -> entry.getId() == m_test.getId());
    }

    public void disconnect() throws SQLException {
    }
}
