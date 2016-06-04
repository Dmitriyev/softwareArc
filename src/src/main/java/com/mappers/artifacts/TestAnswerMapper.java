package com.mappers.artifacts;

import com.businesslogic.artifacts.TestAnswer;
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
public class TestAnswerMapper implements Mapper<TestAnswer> {
    private final static Logger logger = Logger.getLogger(ApplicationMapper.class);
    private static Connection connection;

    public TestAnswerMapper(DataSource dataSource) throws SQLException {
        connection = dataSource.getConnection();
        if(!connection.isClosed()) {
            logger.debug("Connection is open!");
        }
    }

    public TestAnswer find(long id) throws SQLException {
        String SQL_GETTESTANSWER = "SELECT id,student_id,tets_task_id,answer_text FROM TestAnswers WHERE id=?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_GETTESTANSWER);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.first())
            return new TestAnswer(resultSet.getLong("id"),
                    resultSet.getLong("student_id"),
                    resultSet.getLong("tets_task_id"),
                    resultSet.getString("answer_text"));
        return null;
    }

    public List<TestAnswer> findAll() throws SQLException {
        String SQL_GETALLTESTANSWERS = "SELCT * FROM TestAnswers";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_GETALLTESTANSWERS);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<TestAnswer> resultList = new ArrayList<TestAnswer>();
        while(resultSet.next()) {
            TestAnswer m_answer = new TestAnswer(resultSet.getLong("id"),
                    resultSet.getLong("student_id"),
                    resultSet.getLong("tets_task_id"),
                    resultSet.getString("answer_text"));
            resultList.add(m_answer);
        }
        return resultList;
    }

    public void insert(TestAnswer m_answer) throws SQLException {
        String SQL_INSERTTESTANSWER = "INSERT INTO TestAnswers (student_id,tets_task_id,answer_text) VALUES(?,?,?)";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_INSERTTESTANSWER);
        preparedStatement.setLong(1, m_answer.getStudentId());
        preparedStatement.setLong(2, m_answer.getTaskId());
        preparedStatement.setString(3, m_answer.getText());
        preparedStatement.execute();
    }

    public void update(TestAnswer m_answer) throws SQLException {
        String SQL_UPDATETESTANSWER = "UPDATE TestAnswers SET student_id=?,tets_task_id=?,answer_text=? WHERE id=?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_UPDATETESTANSWER);
        preparedStatement.setLong(4, m_answer.getId());
        preparedStatement.setLong(1, m_answer.getStudentId());
        preparedStatement.setLong(2, m_answer.getTaskId());
        preparedStatement.setString(3, m_answer.getText());
        preparedStatement.execute();
    }

    public void delete(TestAnswer m_answer) throws SQLException {
        String SQL_DELETETESTANSWER = "DELETE FROM TestAnswers WHERE id=?";
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(SQL_DELETETESTANSWER);
        preparedStatement.setLong(1, m_answer.getId());
        preparedStatement.execute();
    }

    public void closeConnection() throws SQLException {
        connection.close();
        if(connection.isClosed()) {
            logger.debug("Connection is closed!");
        }
    }
}
