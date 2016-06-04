package com.mappers.artifacts;

import com.businesslogic.artifacts.Plan;
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
public class PlanMapper implements Mapper<Plan> {
    private final static Logger logger = Logger.getLogger(ApplicationMapper.class);
    private static Connection connection;

    public PlanMapper(DataSource dataSource) throws SQLException {
        connection = dataSource.getConnection();
        if(!connection.isClosed()) {
            logger.debug("Connection is open!");
        }
    }

    public Plan find(long id) throws SQLException {
        String SQL_GETPLAN = "SELECT id,student_id,plan_text,validated FROM Plans WHERE id=?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_GETPLAN);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.first())
            return new Plan(resultSet.getLong("id"),
                    resultSet.getLong("student_id"),
                    resultSet.getString("plan_text"),
                    resultSet.getBoolean("validated"));
        return null;
    }

    public List<Plan> findAll() throws SQLException {
        String SQL_GETALLPLANS = "SELECT * FROM Plans";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_GETALLPLANS);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Plan> resultList = new ArrayList<Plan>();
        while(resultSet.next()) {
            Plan m_plan = new Plan(resultSet.getLong("id"),
                    resultSet.getLong("student_id"),
                    resultSet.getString("plan_text"),
                    resultSet.getBoolean("validated"));
            resultList.add(m_plan);
        }
        return resultList;
    }

    public void insert(Plan m_plan) throws SQLException {
        String SQL_INSERTPLAN = "INSERT INTO Plans (student_id,plan_text,validated) VALUES(?,?,?)";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_INSERTPLAN);
        preparedStatement.setLong(1, m_plan.getStudentId());
        preparedStatement.setString(2, m_plan.getText());
        preparedStatement.setBoolean(3, m_plan.isValidated());
        preparedStatement.execute();
    }

    public void update(Plan m_plan) throws SQLException {
        String SQL_UPDATEPLAN = "UPDATE Plans SET student_id=?,plan_text=?,validated=? WHERE id=?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_UPDATEPLAN);
        preparedStatement.setLong(4, m_plan.getId());
        preparedStatement.setLong(1, m_plan.getStudentId());
        preparedStatement.setString(2, m_plan.getText());
        preparedStatement.setBoolean(3, m_plan.isValidated());
        preparedStatement.execute();
    }

    public void delete(Plan m_plan) throws SQLException {
        String SQL_DELETEPLAN = "DELETE FROM Plans WHERE id=?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_DELETEPLAN);
        preparedStatement.setLong(1, m_plan.getId());
        preparedStatement.execute();
    }

    public void closeConnection() throws SQLException {
        connection.close();
        if(connection.isClosed()) {
            logger.debug("Connection is closed!");
        }
    }
}
