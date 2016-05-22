package com.mappers.database;

/**
 * Created by pitochka on 22.05.16.
 */
import java.io.IOException;

import com.utils.AppProperties;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * Created by Admin on 21.04.2016.
 */
public class DataSourceGateway {

    private static DataSourceGateway dataSourceGateway;
    private static MysqlDataSource dataSource;

    private DataSourceGateway() throws IOException {

        AppProperties.readProperties();

        dataSource = new MysqlDataSource();
        dataSource.setURL(AppProperties.getDbUrl());
        dataSource.setUser(AppProperties.getUSER());
        dataSource.setPassword(AppProperties.getPASSWD());

        try {
            Class.forName(AppProperties.getDRIVERNAME());
        } catch (ClassNotFoundException se) {
            se.printStackTrace();
        }
    }

    public static DataSourceGateway getInstance() throws IOException {
        if(dataSourceGateway == null)
            dataSourceGateway = new DataSourceGateway();
        return dataSourceGateway;
    }

    public static MysqlDataSource getDataSource() {
        return dataSource;
    }


}


