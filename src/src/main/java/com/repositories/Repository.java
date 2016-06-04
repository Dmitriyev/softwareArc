package com.repositories;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by pitochka on 04.06.16.
 */
public interface Repository<T> {
    List<T> getAll() throws SQLException;
    T get(T item) throws SQLException;
    void create(T item) throws SQLException;
    void update(T item) throws SQLException;
    void delete(T item) throws SQLException;
    void disconnect() throws SQLException;
}
