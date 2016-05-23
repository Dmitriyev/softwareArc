package com.mappers.artifacts;

import com.businesslogic.artifacts.Application;
import com.mappers.Mapper;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pitochka on 22.05.16.
 */
public class ApplicationMapper implements Mapper<Application> {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;

    public ApplicationMapper(DataSource dataSource) throws SQLException {
        connection = dataSource.getConnection();
    }

    public Application find(long id) throws SQLException {
        String SQL_GETAPPLIACTION = "SELECT id,studentName,registred FROM Applications WHERE id=?";
        preparedStatement = connection.prepareStatement(SQL_GETAPPLIACTION);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next())
            return new Application(resultSet.getLong("id"),
                    resultSet.getString("studentName"),
                    resultSet.getBoolean("registred"));
        return null;
    }

    public List<Application> findAll() throws SQLException {
        String SQL_GETALLAPPLICATIONS = "SELECT * FROM Applications";
        preparedStatement = connection.prepareStatement(SQL_GETALLAPPLICATIONS);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Application> resultList = new ArrayList<Application>();
        while(resultSet.next()) {
            Application m_application = new Application(resultSet.getLong("id"),
                    resultSet.getString("studentName"),
                    resultSet.getBoolean("registred"));
            resultList.add(m_application);
        }

        return resultList;
    }

    public void insert(Application m_application) throws SQLException {
        String SQL_INSERTAPPLICATION = "INSERT INTO Applications (studentName,registred) VALUES(?,?)";
        preparedStatement = connection.prepareStatement(SQL_INSERTAPPLICATION);
        preparedStatement.setString(1, m_application.getName());
        preparedStatement.setBoolean(2, m_application.getStatus());
        preparedStatement.execute();
    }

    public void update(Application m_application) throws SQLException {
        String SQL_UPDATEAPPLICATION = "UPDATE Applications SET studentName=?,registred=? WHERE id=?";
        preparedStatement = connection.prepareStatement(SQL_UPDATEAPPLICATION);
        preparedStatement.setLong(3, m_application.getId());
        preparedStatement.setString(1, m_application.getName());
        preparedStatement.setBoolean(2, m_application.getStatus());
        preparedStatement.execute();
    }

    public void delete(long id) throws SQLException {
        String SQL_DELETEAPPLICATION = "DELETE FROM Applications WHERE id=?";
        preparedStatement = connection.prepareStatement(SQL_DELETEAPPLICATION);
        preparedStatement.setLong(1, id);
        preparedStatement.execute();
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}
