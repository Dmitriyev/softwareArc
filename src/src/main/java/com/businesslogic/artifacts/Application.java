package com.businesslogic.artifacts;

import com.mappers.artifacts.ApplicationMapper;
import com.mappers.database.DataSourceGateway;

import java.io.IOException;
import java.sql.SQLException;

/**
Заявление
 */

public class Application {
    private long id;
    private long student_id;
    private boolean registred;

    private static ApplicationMapper m_applicationMapper;

    public Application(long student_id, boolean registred) throws SQLException, IOException{
        this.student_id = student_id;
        this.registred = registred;
        m_applicationMapper = new ApplicationMapper(DataSourceGateway.getInstance().getDataSource());
        m_applicationMapper.insert(this);
    }

//    public Application(long id, long student_id) {
//        this.student_id = student_id;
//        this.id = id;
//    }

    public Application(long id, long student_id, boolean registred) {
        this.student_id = student_id;
        this.id = id;
        this.registred = registred;
    }

    public void register() throws SQLException{
        this.registred = true;
        m_applicationMapper.update(this);
    }

    public void delete() throws SQLException {
        m_applicationMapper.delete(this);
    }

    public long getId() {
        return this.id;
    }

    public long getStudentId() {
        return this.student_id;
    }

    public boolean getStatus() {
        return this.registred;
    }

    public void setStatus(boolean status) {
        this.registred = status;
    }
}
