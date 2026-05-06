package com.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCInjection  {
    public static void main(String[] args) throws Exception {

        // 1. Register the JDBC driver (optional in newer versions)
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. Get the database connection
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql:///atguigu",
                "root",
                "abc123"
        );

        // 3. Create a Statement object
        Statement statement = connection.createStatement();

        // Prompt the user to enter an employee name
        System.out.println("Please enter the employee name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
//        abc' or '1'='1

        // 4. Write and execute the SQL statementa
        String sql = "SELECT emp_id, emp_name, emp_salary, emp_age FROM t_emp WHERE emp_name = '" + name + "'";
        ResultSet resultSet = statement.executeQuery(sql);

        // 5. Traverse the result set
        while (resultSet.next()) {
            int empId = resultSet.getInt("emp_id");
            String empName = resultSet.getString("emp_name");
            double empSalary = resultSet.getDouble("emp_salary");
            int empAge = resultSet.getInt("emp_age");

            System.out.println(empId + "\t" + empName + "\t" + empSalary + "\t" + empAge);
        }

        // 6. Close resources
        resultSet.close();
        statement.close();
        connection.close();
    }
}
