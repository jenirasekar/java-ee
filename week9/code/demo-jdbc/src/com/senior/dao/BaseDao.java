package com.senior.dao;

import com.senior.util.JDBCUtilV2;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
    /**
     * A common method for insert, delete, and update operations.
     *
     * @param sql    the SQL statement to execute
     * @param params the values used for the placeholders in the SQL statement
     * @return the number of affected rows
     */
    public int executeUpdate(String sql, Object... params) throws Exception{

        // Step 1: Get the database connection
        Connection connection = JDBCUtilV2.getConnection();

        // Step 2: Create the PreparedStatement object
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // Step 3: Set values for the placeholders
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {

                // The placeholder index starts from 1,
                // but the array index starts from 0
                preparedStatement.setObject(i + 1, params[i]);
            }
        }

        // Step 4: Execute the update operation
        int row = preparedStatement.executeUpdate();

        // Step 5: Release resources
        preparedStatement.close();
        if (connection.getAutoCommit()){
            JDBCUtilV2.release();
        }

        // Step 6: Return the number of affected rows
        return row;
    }
/**
 * General query method:
 * multi-row multi-column, single-row multi-column, and single-row single-column
 *
 * Multi-row multi-column: List<Employee>
 * Single-row multi-column: Employee
 * Single-row single-column: only one result is returned,
 * such as Double, Integer, and so on
 *
 * Encapsulation process:
 * 1. Return type:
 *    The generic type is uncertain inside BaseDAO,
 *    but the caller knows it.
 *    So when calling the method, the caller only needs to tell BaseDAO
 *    the result type of this query.
 *
 * 2. Returned result:
 *    A List is universal.
 *    It can store multiple results,
 *    and it can also store just one result by using get(0).
 *
 * 3. Result encapsulation:
 *    Reflection is used.
 *    Therefore, the caller needs to tell BaseDAO
 *    the class object of the target type to be encapsulated.
 */
    /**
     * General query method:
     * multi-row multi-column -> List<T>
     *
     * @param clazz  target class object
     * @param sql    SQL statement
     * @param params values for placeholders
     * @param <T>    target type
     * @return query result list
     */
    public <T> List<T> executeQuery(Class<T> clazz, String sql, Object... params) throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtilV2.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }

            resultSet = preparedStatement.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            List<T> list = new ArrayList<>();

            // Process each row
            while (resultSet.next()) {

                // Create one object for one row
                T t = clazz.getDeclaredConstructor().newInstance();

                // Process each column in the current row
                for (int i = 1; i <= columnCount; i++) {

                    // Get the value of the current column
                    Object value = resultSet.getObject(i);

                    // Get the column label (alias)
                    String fieldName = metaData.getColumnLabel(i);

                    // Find the corresponding field in the class
                    Field field = clazz.getDeclaredField(fieldName);
//                    empAge  查到这个  然后通过这个反射出set这个的方法

                    // Break private access restriction
                    field.setAccessible(true);

                    // Assign the column value to the field of the object
                    field.set(t, value);

//                    employee.setEmpAge(...)
                }

                // Add the encapsulated object to the list
                list.add(t);
            }

            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if (connection.getAutoCommit()){
                JDBCUtilV2.release();
            }

        }
    }

    /**
     * General query method:
     * single-row multi-column -> T
     *
     * @param clazz  target class object
     * @param sql    SQL statement
     * @param params values for placeholders
     * @param <T>    target type
     * @return one object or null
     */
    public <T> T executeQueryOne(Class<T> clazz, String sql, Object... params) throws Exception{
        List<T> list = executeQuery(clazz, sql, params);
        return list.isEmpty() ? null : list.get(0);
    }

    /**
     * General query method:
     * single-row single-column -> scalar value
     *
     * @param sql    SQL statement
     * @param params values for placeholders
     * @return one single value
     */
    public Object executeScalar(String sql, Object... params) throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtilV2.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getObject(1);
            }

            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if (connection.getAutoCommit()){
                JDBCUtilV2.release();
            }
        }
    }

}
