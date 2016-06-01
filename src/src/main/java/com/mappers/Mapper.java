package com.mappers;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by pitochka on 22.05.16.
 */
public interface Mapper<T> {
    T find(long id) throws SQLException;
    List<T> findAll() throws SQLException;
    void insert(T item) throws SQLException;
    void update(T item) throws SQLException;
    void delete(T item) throws SQLException;
    void closeConnection() throws SQLException;
}
