package com.mappers.artifacts;

import com.businesslogic.artifacts.TestTask;
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
public class TestTaskMapper implements Mapper<TestTask> {
    private final static Logger logger = Logger.getLogger(ApplicationMapper.class);
    private static Connection connection;

    public TestTaskMapper(DataSource dataSource) throws SQLException {
        connection = dataSource.getConnection();
        if(!connection.isClosed()) {
            logger.debug("Connection is open!");
        }
    }

    public TestTask find(long id) throws SQLException {
        String SQL_GETTESTTASK = "SELECT id,test_id,task_text FROM TestTasks WHERE id=?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_GETTESTTASK);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.first())
            return new TestTask(resultSet.getLong("id"),
                    resultSet.getLong("test_id"),
                    resultSet.getString("task_text"));
        return null;
    }

    public List<TestTask> findAll() throws SQLException {
        String SQL_GETALLTESTTASKS = "SELECT * FROM TestTasks";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_GETALLTESTTASKS);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<TestTask> resultList = new ArrayList<TestTask>();
        while(resultSet.next()) {
            TestTask m_task = new TestTask(resultSet.getLong("id"),
                    resultSet.getLong("test_id"),
                    resultSet.getString("task_text"));
            resultList.add(m_task);
        }
        return resultList;
    }

    public void insert(TestTask m_task) throws SQLException {
        String SQL_INSERTTESTTASK = "INSERT INTO TestTasks (test_id,task_text) VALUES(?,?)";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_INSERTTESTTASK);
        preparedStatement.setLong(1, m_task.getTestId());
        preparedStatement.setString(2, m_task.getText());
        preparedStatement.execute();
    }

    public void update(TestTask m_task) throws SQLException {
        String SQL_UPDATETESTTASK = "UPDATE TestTasks SET test_id=?,task_text=? WHERE id=?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_UPDATETESTTASK);
        preparedStatement.setLong(3, m_task.getId());
        preparedStatement.setLong(1, m_task.getTestId());
        preparedStatement.setString(2, m_task.getText());
        preparedStatement.execute();
    }

    public void delete(TestTask m_task) throws SQLException {
        String SQL_DELETETESTTASK = "DELETE FROM TestTasks WHERE id=?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_DELETETESTTASK);
        preparedStatement.setLong(1, m_task.getId());
        preparedStatement.execute();
    }

    public void closeConnection() throws SQLException {
        connection.close();
        if(connection.isClosed()) {
            logger.debug("Connection is closed!");
        }
    }
}
