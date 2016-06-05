package com.mappers.artifacts;

import com.businesslogic.artifacts.Application;
import com.mappers.Mapper;

import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pitochka on 22.05.16.
 */
public class ApplicationMapper implements Mapper<Application> {
    private final static Logger logger = Logger.getLogger(ApplicationMapper.class);
    private static Connection connection;

    public ApplicationMapper(DataSource dataSource) throws SQLException {
        connection = dataSource.getConnection();
        if(!connection.isClosed()) {
            logger.debug("Connection is open!");
        }
    }

    public Application find(long id) throws SQLException {
        String SQL_GETAPPLIACTION = "SELECT id,student_id,registred FROM Applications WHERE student_id=?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_GETAPPLIACTION);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.first())
            return new Application(resultSet.getLong("id"),
                    resultSet.getLong("student_id"),
                    resultSet.getBoolean("registred"));
        return null;
    }

    public List<Application> findAll() throws SQLException {
        String SQL_GETALLAPPLICATIONS = "SELECT * FROM Applications";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_GETALLAPPLICATIONS);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Application> resultList = new ArrayList<Application>();
        while(resultSet.next()) {
            Application m_application = new Application(resultSet.getLong("id"),
                    resultSet.getLong("student_id"),
                    resultSet.getBoolean("registred"));
            resultList.add(m_application);
        }
        return resultList;
    }

    public void insert(Application m_application) throws SQLException {
        String SQL_INSERTAPPLICATION = "INSERT INTO Applications (student_id,registred) VALUES(?,?)";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_INSERTAPPLICATION);
        preparedStatement.setLong(1, m_application.getStudentId());
        preparedStatement.setBoolean(2, m_application.getStatus());
        preparedStatement.execute();
    }

    public void update(Application m_application) throws SQLException {
        String SQL_UPDATEAPPLICATION = "UPDATE Applications SET student_id=?,registred=? WHERE student_id=?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_UPDATEAPPLICATION);
        preparedStatement.setLong(3, m_application.getStudentId());
        preparedStatement.setLong(1, m_application.getStudentId());
        preparedStatement.setBoolean(2, m_application.getStatus());
        preparedStatement.execute();
    }

    public void delete(Application m_application) throws SQLException {
        String SQL_DELETEAPPLICATION = "DELETE FROM Applications WHERE student_id=?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_DELETEAPPLICATION);
        preparedStatement.setLong(1, m_application.getStudentId());
        preparedStatement.execute();
    }

    public void closeConnection() throws SQLException {
        connection.close();
        if(connection.isClosed()) {
            logger.debug("Connection is closed!");
        }
    }
}
