package com.base;

import org.junit.Test;

import java.sql.*;

public class JDBCOperation {

    @Test
    public void testQuerySingleRowAndCol() throws Exception {

        // 1. Register the JDBC driver (can be omitted)
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. Get the database connection
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql:///atguigu",
                "root",
                "0713"
        );

        // 3. Prepare the SQL statement
//        SELECT COUNT(*) AS count FROM t_emp
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT COUNT(*) AS count FROM t_emp"
        );

        // 4. Execute the query
        ResultSet resultSet = preparedStatement.executeQuery();

        // 5. Process the result
        // Since the query returns only one row and one column,
        // call next() once and then retrieve the value
        if (resultSet.next()) {
            int count = resultSet.getInt("count");
            System.out.println(count);
        }

        // 6. Release resources
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testQuerySingleRow() throws Exception {

        // 1. Register the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. Get the database connection
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql:///atguigu",
                "root",
                "0713"
        );

        // 3. Prepare the SQL statement and obtain the PreparedStatement object
//        SELECT emp_id, emp_name, emp_salary, emp_age FROM t_emp WHERE emp_id = ?
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT emp_id, emp_name, emp_salary, emp_age FROM t_emp WHERE emp_id = ?"
        );

        // 4. Set the value for the placeholder, execute the query, and get the result set
        preparedStatement.setInt(1, 5);
        ResultSet resultSet = preparedStatement.executeQuery();

        // 5. Process the result
        while (resultSet.next()) {
            int empId = resultSet.getInt("emp_id");
            String empName = resultSet.getString("emp_name");
            double empSalary = resultSet.getDouble("emp_salary");
            int empAge = resultSet.getInt("emp_age");

            System.out.println(empId + "\t" + empName + "\t" + empSalary + "\t" + empAge);
        }

        // 6. Release resources
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testQueryMoreRow() throws Exception {

        // 1. Register the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. Get the database connection
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql:///atguigu",
                "root",
                "0713"
        );

        // 3. Prepare the SQL statement and obtain the PreparedStatement object
//        SELECT emp_id, emp_name, emp_salary, emp_age FROM t_emp WHERE emp_age > ?
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT emp_id, emp_name, emp_salary, emp_age FROM t_emp WHERE emp_age > ?"
        );

        // 4. Set the value for the placeholder, execute the query, and get the result set
        preparedStatement.setInt(1, 25);
        ResultSet resultSet = preparedStatement.executeQuery();

        // 5. Process the result
        while (resultSet.next()) {
            int empId = resultSet.getInt("emp_id");
            String empName = resultSet.getString("emp_name");
            double empSalary = resultSet.getDouble("emp_salary");
            int empAge = resultSet.getInt("emp_age");

            System.out.println(empId + "\t" + empName + "\t" + empSalary + "\t" + empAge);
        }

        // 6. Release resources
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testInsert() throws SQLException {

        // 1. Get the database connection
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql:///atguigu",
                "root",
                "0713"
        );

        // 2. Prepare the SQL statement
//        INSERT INTO t_emp(emp_name, emp_salary, emp_age) VALUES (?, ?, ?)
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO t_emp(emp_name, emp_salary, emp_age) VALUES (?, ?, ?)"
        );

        // 3. Set parameter values
        preparedStatement.setString(1, "rose");
        preparedStatement.setDouble(2, 345.67);
        preparedStatement.setInt(3, 28);

        // 4. Execute the update operation
        int result = preparedStatement.executeUpdate();

        // 5. Check the result based on the number of affected rows
        if (result > 0) {
            System.out.println("Success!");
        } else {
            System.out.println("Failed!");
        }

        // 6. Close resources
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testUpdate() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql:///atguigu",
                "root",
                "0713"
        );
//        UPDATE t_emp SET emp_salary = ? WHERE emp_id = ?
        PreparedStatement preparedStatement = connection.prepareStatement("");
        preparedStatement.setDouble(1, 666);
        preparedStatement.setInt(2, 6);
        int result = preparedStatement.executeUpdate();
        if (result > 0) {
            System.out.println("Success!");
        } else {
            System.out.println("Failed!");
        }

        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testDelete() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql:///atguigu",
                "root",
                "0713"
        );
//        DELETE FROM t_emp WHERE emp_id = ?
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM t_emp WHERE emp_id = ?");
//        preparedStatement.setDouble(1, 666);
        preparedStatement.setInt(1, 6);
        int result = preparedStatement.executeUpdate();
        if (result > 0) {
            System.out.println("Success!");
        } else {
            System.out.println("Failed!");
        }

        preparedStatement.close();
        connection.close();
    }
}
