package com.mappers.artifacts;

import com.businesslogic.artifacts.Mark;
import com.mappers.Mapper;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pitochka on 04.06.16.
 */
public class MarkMapper implements Mapper<Mark> {
    private final static Logger logger = Logger.getLogger(ApplicationMapper.class);
    private static Connection connection;

    public MarkMapper(DataSource dataSource) throws SQLException {
        connection = dataSource.getConnection();
        if(!connection.isClosed()) {
            logger.debug("Connection is open!");
        }
    }

    public Mark find(long id) throws SQLException {
        String SQL_GETMARK = "SELECT id,student_id,m_value FROM Marks WHERE id=?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_GETMARK);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.first())
            return new Mark(resultSet.getLong("id"),
                    resultSet.getLong("student_id"),
                    resultSet.getInt("m_value"));
        return null;
    }

    public List<Mark> findAll() throws SQLException {
        String SQL_GETALLMARKS = "SELECT * FROM Marks";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_GETALLMARKS);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Mark> resultList = new ArrayList<Mark>();
        while(resultSet.next()) {
            Mark m_mark = new Mark(resultSet.getLong("id"),
                        resultSet.getLong("student_id"),
                        resultSet.getInt("m_value"));
            resultList.add(m_mark);
        }
        return resultList;
    }

    public void insert(Mark m_mark) throws SQLException {
        String SQL_INSERTMARK = "INSERT INTO Marks (student_id,m_value) VALUES(?,?)";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_INSERTMARK);
        preparedStatement.setLong(1, m_mark.getStudentId());
        preparedStatement.setInt(2, m_mark.getValue());
        preparedStatement.execute();
    }

    public void update(Mark m_mark) throws SQLException {
        String SQL_UPDATEMARK = "UPDATE Marks SET student_id=?,m_value=? WHERE id=?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_UPDATEMARK);
        preparedStatement.setLong(3, m_mark.getId());
        preparedStatement.setLong(1, m_mark.getStudentId());
        preparedStatement.setInt(2, m_mark.getValue());
        preparedStatement.execute();
    }

    public void delete(Mark m_mark) throws SQLException {
        String SQL_DELETEMARK = "DELETE FROM Marks WHERE id=?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_DELETEMARK);
        preparedStatement.setLong(1, m_mark.getId());
        preparedStatement.execute();
    }

    public void closeConnection() throws SQLException {
        connection.close();
        if(connection.isClosed()) {
            logger.debug("Connection is closed!");
        }
    }
}

