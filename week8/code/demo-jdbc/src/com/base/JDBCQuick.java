package com.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCQuick {
    public static void main(String[] args) throws Exception {
        // Step 1: Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

// Step 2: Get a database connection
        String url = "jdbc:mysql://localhost:3306/atguigu";
        String username = "root";
        String password = "abc123";
        Connection connection = DriverManager.getConnection(url, username, password);

// Step 3: Create a Statement object
        Statement statement = connection.createStatement();

// Step 4: Execute the SQL query
        String sql = "SELECT emp_id, emp_name, emp_salary, emp_age FROM t_emp";
        ResultSet resultSet = statement.executeQuery(sql);

// Step 5: Traverse the query results
        while (resultSet.next()) {
            int empId = resultSet.getInt("emp_id");
            String empName = resultSet.getString("emp_name");
            double empSalary = resultSet.getDouble("emp_salary");
            int empAge = resultSet.getInt("emp_age");

            System.out.println(empId + "\t" + empName + "\t" + empSalary + "\t" + empAge);


        }
        // Step 6: Close resources
        // Follow the principle: open first, close last
        resultSet.close();
        statement.close();
        connection.close();
    }
}
