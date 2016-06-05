package com.repositories.artifacts;

import com.businesslogic.artifacts.Mark;
import com.repositories.Repository;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pitochka on 05.06.16.
 */
public class MarkRepository implements Repository<Mark> {
    private static List<Mark> MarkList;

    public MarkRepository() throws SQLException, IOException {
        MarkList = new ArrayList<Mark>();
        MarkList.add(new Mark(12, 3));
    }

    public MarkRepository(DataSource dataSource) {
        MarkList = new ArrayList<Mark>();
    }

    public List<Mark> getAll() {
        return this.MarkList;
    }

    public Mark get(Mark m_mark) {
        List<Mark> m_list = MarkList.stream()
                .filter(entry -> entry.getId() == m_mark.getId())
                .collect(Collectors.toList());
        return m_list.get(0);
    }

    public void create(Mark m_mark) {
        MarkList.add(m_mark);
    }

    public void update(Mark m_mark) {

    }

    public void delete(Mark m_mark) {
        MarkList.removeIf(entry -> entry.getId() == m_mark.getId());
    }

    public void disconnect() {
    }
}
