package com.utils;

/**
 * Created by pitochka on 22.05.16.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 * Created by pitochka on 13.05.2016.
 */
public class AppProperties {

    private final static Logger logger = Logger.getLogger(AppProperties.class);
    private static String DB_URL;
    private static String DB_USER;
    private static String DB_PASSWD;
    private static String DRIVERNAME;
    private static FileInputStream fileInputStream;
    private static String SERVICE_URL;
    private static String SERVICE_USER;
    private static String SERVICE_PASSWD;
    private static String SERVER_PORT;

    public static void readProperties() throws IOException {
        try {
            Properties properties = new Properties();
            String propFileName = "config.properties";
            fileInputStream = new FileInputStream(propFileName);
            if(fileInputStream != null) {
                properties.load(fileInputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName  + "' not found in the classpath");
            }

            String database = properties.getProperty("database");
            DRIVERNAME = properties.getProperty("drivername");
            String dbname = properties.getProperty("db_name");
            String useSSL = properties.getProperty("useSSL");
            String db_host = properties.getProperty("db_host");
            String db_port = properties.getProperty("db_port");
            DB_USER = properties.getProperty("db_user");
            DB_PASSWD = properties.getProperty("db_passwd");
            DB_URL = "jdbc:" + database + "://" + db_host + ":" + db_port + "/" + dbname + "?useSSL=" + useSSL;

            String serviceprotocol = properties.getProperty("service_protocol");
            String servicedomain = properties.getProperty("service_domain");
            String servicepath = properties.getProperty("service_path");
            SERVICE_URL = serviceprotocol + servicedomain + "/";
            SERVICE_USER = properties.getProperty("service_user");
            SERVICE_PASSWD = properties.getProperty("service_passwd");
            SERVER_PORT = properties.getProperty("server_port");
            logger.debug(DB_URL);
            logger.debug(SERVICE_URL);
        } catch (Exception e) {
            logger.error("Exception: " + e.getMessage());
        } finally {
            fileInputStream.close();
        }
    }

    public static String getDbUrl() {
        return DB_URL;
    }

    public static String getDRIVERNAME() {
        return DRIVERNAME;
    }

    public static String getPASSWD() {
        return DB_PASSWD;
    }

    public static String getUSER() {
        return DB_USER;
    }

    public static String getServiceUrl() { return SERVICE_URL; }

    public static String getServicePasswd() {
        return SERVICE_PASSWD;
    }

    public static String getServiceUser() {
        return SERVICE_USER;
    }

    public static String getServerPort() {
        return SERVER_PORT;
    }
}
