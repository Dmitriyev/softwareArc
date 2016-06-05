package com.mappers.events;

import com.businesslogic.events.Test;
import com.mappers.Mapper;
import com.mappers.artifacts.TestTaskMapper;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pitochka on 05.06.16.
 */
public class TestMapper implements Mapper<Test> {
    private final static Logger logger = Logger.getLogger(TestMapper.class);
    private static TestTaskMapper m_testTaskMapper;
    private static Connection connection;

    public TestMapper(DataSource dataSource) throws SQLException {
        connection = dataSource.getConnection();
        m_testTaskMapper = new TestTaskMapper(dataSource);
        if(!connection.isClosed()) {
            logger.debug("Connection is open!");
        }
    }

    public Test find(long id) throws SQLException {
        String SQL_GETTEST = "SELECT id,test_date FROM Tests WHERE id=?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_GETTEST);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.first()) {
            Test m_test = new Test(resultSet.getLong("id"),
                    resultSet.getDate("test_date"));
            m_test.setTask(m_testTaskMapper.find(m_test.getId()));
            return m_test;
        }
        return null;
    }

    public List<Test> findAll() throws SQLException {
        String SQL_GETALLTESTS = "SELECT * FROM Tests";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_GETALLTESTS);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Test> resultList = new ArrayList<Test>();
        while(resultSet.next()) {
            Test m_test = new Test(resultSet.getLong("id"),
                    resultSet.getDate("test_date"));
            m_test.setTask(m_testTaskMapper.find(m_test.getId()));
            resultList.add(m_test);
        }
        return resultList;
    }

    public void insert(Test m_test) throws SQLException {
        String SQL_INSERTTEST = "INSERT INTO Tests (test_date) VALUES(?)";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_INSERTTEST);
        preparedStatement.setDate(1, new java.sql.Date(m_test.getDate().getTime()));
        preparedStatement.execute();
    }

    public void update(Test m_test) throws SQLException {
        String SQL_UPDATETEST = "UPDATE Tests SET test_date=? WHERE id=?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_UPDATETEST);
        preparedStatement.setLong(2, m_test.getId());
        preparedStatement.setDate(1, new java.sql.Date(m_test.getDate().getTime()));
        preparedStatement.execute();
    }

    public void deleteByDate(Test m_test) throws SQLException {
        String SQL_DELETETEST = "DELETE FROM Tests WHERE test_date=?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_DELETETEST);
        preparedStatement.setDate(1, new java.sql.Date(m_test.getDate().getTime()));
        preparedStatement.execute();
    }

    public void delete(Test m_test) throws SQLException {
        String SQL_DELETETEST = "DELETE FROM Tests WHERE id=?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_DELETETEST);
        preparedStatement.setLong(1, m_test.getId());
        preparedStatement.execute();
    }

    public void closeConnection() throws SQLException {
        connection.close();
        if(connection.isClosed()) {
            logger.debug("Connection is closed!");
        }
    }
}
