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
public class ApplicationMappers implements Mapper<Application> {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;

    public ApplicationMappers(DataSource dataSource) throws SQLException {
        connection = dataSource.getConnection();
    }

    @Override
    public Application find(long id) throws SQLException {
        String SQL_GETAPPLIACTION = "SELECT id,studentName FROM Applications WHERE id=?";
        preparedStatement = connection.prepareStatement(SQL_GETAPPLIACTION);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Application m_application = new Application(resultSet.getLong("id"),
                resultSet.getString("studentName"));

        return m_application;
    }

    @Override
    public List<Application> findAll() throws SQLException {
        String SQL_GETALLAPPLICATIONS = "SELECT * FROM Applications";
        preparedStatement = connection.prepareStatement(SQL_GETALLAPPLICATIONS);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Application> resultList = new ArrayList<Application>();
        while(resultSet.next()) {
            Application m_application = new Application(resultSet.getLong("id"),
                    resultSet.getString("studentName"));
            resultList.add(m_application);
        }

        return resultList;
    }

    @Override
    public void insert(Application m_application) throws SQLException {
        String SQL_INSERTAPPLICATION = "INSERT INTO Applications (id,studentName) VALUES(?,?)";
        preparedStatement = connection.prepareStatement(SQL_INSERTAPPLICATION);
        preparedStatement.setLong(1, m_application.getId());
        preparedStatement.setString(2, m_application.getName());
        preparedStatement.execute();
    }

    @Override
    public void update(Application m_application) throws SQLException {
        String SQL_UPDATEAPPLICATION = "UPDATE Applications SET studentName=? WHERE id=?";
        preparedStatement = connection.prepareStatement(SQL_UPDATEAPPLICATION);
        preparedStatement.setLong(1, m_application.getId());
        preparedStatement.setString(2, m_application.getName());
        preparedStatement.execute();
    }

    @Override
    public void delete(long id) throws SQLException {
        String SQL_DELETEAPPLICATION = "DELETE FROM Applications WHERE id=?";
        preparedStatement = connection.prepareStatement(SQL_DELETEAPPLICATION);
        preparedStatement.setLong(1, id);
        preparedStatement.execute();
    }

    @Override
    public void closeConnection() throws SQLException {
        connection.close();
    }
}
