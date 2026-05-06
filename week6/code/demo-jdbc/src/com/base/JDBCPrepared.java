package com.base;

import java.sql.*;
import java.util.Scanner;

public class JDBCPrepared {
    public static void main(String[] args) throws Exception {

        // 1. Register the JDBC driver
        // In newer JDBC versions, this step is often optional
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. Get the database connection
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql:///atguigu",
                "root",
                "0713"
        );

        // 3. Write the SQL statement with a placeholder
        String sql = "SELECT emp_id, emp_name, emp_salary, emp_age FROM t_emp WHERE emp_name = ?";

        // 4. Create a PreparedStatement object
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // 5. Prompt the user to enter an employee name
        System.out.println("Please enter the employee name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        // Example malicious input:
        // abc' or '1'='1
        // PreparedStatement can prevent SQL injection

        // 6. Set the parameter value for the placeholder
        preparedStatement.setString(1, name);

        // 7. Execute the query and get the result set
        ResultSet resultSet = preparedStatement.executeQuery();

        // 8. Traverse the result set
        while (resultSet.next()) {
            int empId = resultSet.getInt("emp_id");
            String empName = resultSet.getString("emp_name");
            double empSalary = resultSet.getDouble("emp_salary");
            int empAge = resultSet.getInt("emp_age");

            System.out.println(empId + "\t" + empName + "\t" + empSalary + "\t" + empAge);
        }

        // 9. Close resources
        resultSet.close();
        preparedStatement.close();
        connection.close();
        scanner.close();
    }
}