package com.mappers.artifacts;

import com.businesslogic.artifacts.Preferences;
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
public class PreferencesMapper implements Mapper<Preferences> {
    private final static Logger logger = Logger.getLogger(ApplicationMapper.class);
    private static Connection connection;

    public PreferencesMapper(DataSource dataSource) throws SQLException {
        connection = dataSource.getConnection();
        if(!connection.isClosed()) {
            logger.debug("Connection is open!");
        }
    }

    public Preferences find(long id) throws SQLException {
        String SQL_GETPREFERENCES = "SELECT id,student_id,preference_text FROM Preferences WHERE student_id=?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_GETPREFERENCES);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.first())
            return new Preferences(resultSet.getLong("id"),
                    resultSet.getLong("student_id"),
                    resultSet.getString("preference_text"));
        return null;
    }

    public List<Preferences> findAll() throws SQLException {
        String SQL_GETALLPREFERENCES = "SELECT * FROM Preferences";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_GETALLPREFERENCES);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Preferences> resultList = new ArrayList<Preferences>();
        while(resultSet.next()) {
            Preferences m_preferences = new Preferences(resultSet.getLong("id"),
                    resultSet.getLong("student_id"),
                    resultSet.getString("preference_text"));
            resultList.add(m_preferences);
        }
        return resultList;
    }

    public void insert(Preferences m_preferences) throws SQLException {
        String SQL_INSERTPREFERENCES = "INSERT INTO Preferences (student_id,preference_text) VALUES(?,?)";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_INSERTPREFERENCES);
        preparedStatement.setLong(1, m_preferences.getStudentId());
        preparedStatement.setString(2, m_preferences.getText());
        preparedStatement.execute();
    }

    public void update(Preferences m_preferences) throws SQLException {
        String SQL_UPDATEPREFERENCES = "UPDATE Preferences SET student_id=?,preference_text=? WHERE student_id=?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_UPDATEPREFERENCES);
        preparedStatement.setLong(3, m_preferences.getStudentId());
        preparedStatement.setLong(1, m_preferences.getStudentId());
        preparedStatement.setString(2, m_preferences.getText());
        preparedStatement.execute();
    }

    public void delete(Preferences m_preferences) throws SQLException {
        String SQL_DELETEPREFERENCES = "DELETE FROM Preferences WHERE student_id=?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_DELETEPREFERENCES);
        preparedStatement.setLong(1, m_preferences.getStudentId());
        preparedStatement.execute();
    }

    public void closeConnection() throws SQLException {
        connection.close();
        if(connection.isClosed()) {
            logger.debug("Connection is closed!");
        }
    }
}
