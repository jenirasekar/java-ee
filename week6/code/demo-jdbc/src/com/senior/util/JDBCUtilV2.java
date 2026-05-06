package com.senior.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtilV2 {

    /**
     * Shared connection pool object.
     *
     * DataSource is used to manage database connections.
     * Here we use the Druid connection pool, so connections are not created
     * and destroyed repeatedly. Instead, they are reused, which improves performance.
     */
    private static DataSource dataSource;

    /**
     * ThreadLocal is used to store one Connection object for each thread.
     *
     * Why use ThreadLocal?
     * In transaction management, multiple DAO operations in the same thread
     * should use the same database connection.
     *
     * This ensures:
     * 1. All operations belong to the same transaction
     * 2. Commit / rollback can work correctly
     * 3. Different threads do not interfere with each other
     */
    private static final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal<>();

    /**
     * Static initialization block.
     *
     * This code is executed only once when the class is first loaded.
     * Its job is to initialize the database connection pool.
     */
    static {
        try {
            // Create a Properties object to load configuration from db.properties
            Properties properties = new Properties();

            /**
             * Read the db.properties file from the classpath.
             *
             * getClassLoader().getResourceAsStream("db.properties")
             * means:
             * - find the file named db.properties in the resources directory
             * - read it as an input stream
             */
            InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");

            // Load the key-value pairs in db.properties into the Properties object
            properties.load(inputStream);

            /**
             * Create the Druid connection pool object according to the configuration.
             *
             * After this step, dataSource can provide database connections from the pool.
             */
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            // Convert checked exceptions into runtime exceptions for simplicity
            throw new RuntimeException(e);
        }
    }

    /**
     * Get the connection bound to the current thread.
     *
     * Core idea:
     * - First check whether the current thread already has a Connection
     * - If yes, return it directly
     * - If not, get a new connection from the connection pool,
     *   bind it to the current thread, and then return it
     *
     * Why do this?
     * This makes sure that all database operations in the same thread
     * use the same Connection object.
     *
     * @return the Connection object bound to the current thread
     */
    public static Connection getConnection() {
        try {
            // Get the Connection currently stored in ThreadLocal for this thread
            Connection connection = THREAD_LOCAL.get();

            /**
             * If the current thread has no bound connection,
             * or the bound connection has already been closed,
             * then fetch a new connection from the pool.
             */
            if (connection == null || connection.isClosed()) {
                // Get a new connection from the Druid connection pool
                connection = dataSource.getConnection();

                // Bind this connection to the current thread
                THREAD_LOCAL.set(connection);
            }

            // Return the connection for current thread use
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Release the connection bound to the current thread.
     *
     * Why is release necessary?
     * After database operations are finished, the connection should be returned
     * to the connection pool. Otherwise, connections may be exhausted.
     *
     * Steps:
     * 1. Get the connection from ThreadLocal
     * 2. If it is not null:
     *    - reset autoCommit to true
     *    - close the connection (actually returns it to the pool)
     *    - remove it from ThreadLocal
     *
     * Why reset autoCommit to true first?
     * Because this connection may have been used in a transaction before,
     * where autoCommit was set to false.
     * Since the connection will be reused later, we should restore it
     * to its default state before returning it to the pool.
     */
    public static void release() {
        try {
            // Get the connection bound to the current thread
            Connection connection = THREAD_LOCAL.get();

            // Release only when the connection exists
            if (connection != null) {
                /**
                 * Restore autoCommit to true.
                 *
                 * This is important because:
                 * - In manual transaction management, autoCommit may be set to false
                 * - If we do not restore it, the next user of this connection
                 *   may accidentally use the old transaction state
                 */
                connection.setAutoCommit(true);

                /**
                 * Close the connection.
                 *
                 * For a normal JDBC connection, close() means physically closing it.
                 * For a connection pool, close() usually means returning it to the pool
                 * instead of actually destroying it.
                 */
                connection.close();

                /**
                 * Remove the connection from ThreadLocal.
                 *
                 * This breaks the binding between the current thread and the connection.
                 * It also avoids memory leaks and ensures that next time this thread
                 * calls getConnection(), it will get a fresh available connection.
                 */
                THREAD_LOCAL.remove();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}