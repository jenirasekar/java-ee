package com.senior.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    // A shared DataSource object
// It represents the connection pool used by the whole project
    private static DataSource dataSource;

    // Static code block
// It runs only once when the class is loaded
// Here we initialize the connection pool in advance
    static {
        try {
            // Create a Properties object to store configuration information
            Properties properties = new Properties();

            // Read the external configuration file db.properties
            InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");

            // Load the key-value pairs into the Properties object
            properties.load(inputStream);

            // Create the Druid connection pool based on the configuration
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            // Convert checked exceptions into runtime exceptions
            throw new RuntimeException(e);
        }
    }

    // A utility method for getting a connection from the connection pool
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // A utility method for releasing a connection
// In a connection pool, close() means returning the connection to the pool
    public static void release(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
