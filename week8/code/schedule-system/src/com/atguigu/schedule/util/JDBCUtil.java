package com.atguigu.schedule.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC utility class.
 * It is used to manage the database connection pool and provide database connections.
 */
public class JDBCUtil {

    // Store one Connection object for each thread
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    // Database connection pool object
    private static DataSource dataSource;

    // Initialize the connection pool when the class is loaded
    static {
        // Read the jdbc.properties configuration file
        Properties properties = new Properties();
        InputStream resourceAsStream =
                JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");

        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            // Create the Druid connection pool according to the configuration file
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Provide the connection pool object.
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * Provide a database connection.
     * If the current thread already has a connection, reuse it.
     * Otherwise, get a new connection from the connection pool.
     */
    public static Connection getConnection() {
        Connection connection = threadLocal.get();

        if (null == connection) {
            try {
                connection = dataSource.getConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            threadLocal.set(connection);
        }

        return connection;
    }

    /**
     * Release the database connection.
     * Remove the connection from ThreadLocal and return it to the connection pool.
     */
    public static void releaseConnection() {
        Connection connection = threadLocal.get();

        if (null != connection) {
            threadLocal.remove();

            try {
                // Reset the connection to auto-commit mode
                connection.setAutoCommit(true);

                // Return the connection to the connection pool
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}