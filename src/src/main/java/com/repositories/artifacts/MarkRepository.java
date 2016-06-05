package com.repositories.artifacts;

import com.businesslogic.artifacts.Mark;
import com.mappers.artifacts.MarkMapper;
import com.mappers.database.DataSourceGateway;
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
    private static MarkMapper m_markMapper;

    public MarkRepository() throws SQLException, IOException {
        MarkList = new ArrayList<Mark>();
        DataSourceGateway gateway = DataSourceGateway.getInstance();
        m_markMapper = new MarkMapper(DataSourceGateway.getDataSource());
        MarkList.add(new Mark(12, 3));
    }

    public MarkRepository(DataSource dataSource) throws SQLException {
        MarkList = new ArrayList<Mark>();
        m_markMapper = new MarkMapper(dataSource);
    }

    public List<Mark> getAll() {
        return this.MarkList;
    }

    public Mark get(Mark m_mark) throws SQLException{
        List<Mark> m_list = MarkList.stream()
                .filter(entry -> entry.getId() == m_mark.getId())
                .collect(Collectors.toList());
        if (m_list.isEmpty()) {
            Mark mark = m_markMapper.find(m_mark.getId());
            m_list.add(mark);
            return mark;
        }
        return m_list.get(0);
    }

    public void create(Mark m_mark) throws SQLException {
        MarkList.add(m_mark);
        m_markMapper.insert(m_mark);
    }

    public void update(Mark m_mark) throws SQLException{
        MarkList.stream()
                .filter(entry -> entry.getId() == m_mark.getId())
                .forEach(entry ->
                        entry.setValue(m_mark.getValue()));
        m_markMapper.update(m_mark);
    }

    public void delete(Mark m_mark) throws SQLException {
        MarkList.removeIf(entry -> entry.getId() == m_mark.getId());
        m_markMapper.delete(m_mark);
    }

    public void disconnect() throws SQLException {
        m_markMapper.closeConnection();
    }
}
