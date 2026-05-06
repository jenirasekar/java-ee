package com.atguigu.schedule.dao;

import com.atguigu.schedule.util.JDBCUtil;

import java.lang.reflect.Field;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * BaseDao is a common DAO parent class.
 * It encapsulates repeated JDBC operations, such as getting connections,
 * creating PreparedStatement objects, setting parameters, executing SQL,
 * processing ResultSet, and releasing resources.
 */
public class BaseDao {

    /**
     * Common query method.
     * It returns a single value or object.
     */
    public <T> T baseQueryObject(Class<T> clazz, String sql, Object... args) {
        T t = null;
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Create PreparedStatement object
            preparedStatement = connection.prepareStatement(sql);

            // Set parameters for the SQL statement
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }

            // Execute query
            resultSet = preparedStatement.executeQuery();

            // Get the first column of the first row
            if (resultSet.next()) {
                t = (T) resultSet.getObject(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close ResultSet
            if (null != resultSet) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // Close PreparedStatement
            if (null != preparedStatement) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // Release database connection
            JDBCUtil.releaseConnection();
        }

        return t;
    }

    /**
     * Common query method.
     * It returns a list of entity objects.
     */
    public <T> List<T> baseQuery(Class clazz, String sql, Object... args) {
        List<T> list = new ArrayList<>();
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Create PreparedStatement object
            preparedStatement = connection.prepareStatement(sql);

            // Set parameters for the SQL statement
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }

            // Execute query
            resultSet = preparedStatement.executeQuery();

            // Get metadata of the result set
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Encapsulate each row of the ResultSet into an entity object by reflection
            while (resultSet.next()) {

                // Create an entity object by reflection
                Object obj = clazz.getDeclaredConstructor().newInstance();

                for (int i = 1; i <= columnCount; i++) {

                    // Get the column name or alias
                    String columnName = metaData.getColumnLabel(i);

                    // Get the value of the current column
                    Object value = resultSet.getObject(columnName);

                    // Handle conversion between LocalDateTime and Timestamp
                    if (value != null && value.getClass().equals(LocalDateTime.class)) {
                        value = Timestamp.valueOf((LocalDateTime) value);
                    }

                    // Get the corresponding field in the entity class
                    Field field = clazz.getDeclaredField(columnName);

                    // Allow access to private fields
                    field.setAccessible(true);

                    // Set the value to the entity object
                    field.set(obj, value);
                }

                // Add the entity object to the list
                list.add((T) obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close ResultSet
            if (null != resultSet) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            // Close PreparedStatement
            if (null != preparedStatement) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            // Release database connection
            JDBCUtil.releaseConnection();
        }

        return list;
    }

    /**
     * Common update method.
     * It is used for insert, delete, and update operations.
     */
    public int baseUpdate(String sql, Object... args) {

        // Get database connection
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        int rows = 0;

        try {
            // Create PreparedStatement object
            preparedStatement = connection.prepareStatement(sql);

            // Set parameters for the SQL statement
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }

            // Execute insert, delete, or update operation
            rows = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close PreparedStatement
            if (null != preparedStatement) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            // Release database connection
            JDBCUtil.releaseConnection();
        }

        // Return the number of affected rows
        return rows;
    }
}