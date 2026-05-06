package com.advanced;

import com.advanced.pojo.Employee;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCAdvanced {

    @Test
    public void testORM() throws Exception{
        // 1. Register the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. Get the database connection
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql:///atguigu",
                "root",
                "abc123"
        );

        // 3. Prepare the SQL statement and obtain the PreparedStatement object
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT emp_id, emp_name, emp_salary, emp_age FROM t_emp WHERE emp_id = ?"
        );

        // 4. Set the value for the placeholder, execute the query, and get the result set
        preparedStatement.setInt(1, 5);
        ResultSet resultSet = preparedStatement.executeQuery();

        Employee employee = null;

        // 5. Process the result
        while (resultSet.next()) {
            employee = new Employee();
            int empId = resultSet.getInt("emp_id");
            String empName = resultSet.getString("emp_name");
            double empSalary = resultSet.getDouble("emp_salary");
            int empAge = resultSet.getInt("emp_age");

            employee.setEmpId(empId);
            employee.setEmpName(empName);
            employee.setEmpSalary(empSalary);
            employee.setEmpAge(empAge);

            System.out.println(employee.toString());

        }

        // 6. Release resources
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testORMList() throws Exception{
        // 1. Register the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. Get the database connection
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql:///atguigu",
                "root",
                "abc123"
        );

        // 3. Prepare the SQL statement and obtain the PreparedStatement object
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT emp_id, emp_name, emp_salary, emp_age FROM t_emp"
        );

        // 4. Set the value for the placeholder, execute the query, and get the result set
//        preparedStatement.setInt(1, 5);
        ResultSet resultSet = preparedStatement.executeQuery();

        Employee employee = null;
        List<Employee>  employeeList = new ArrayList<>();
        // 5. Process the result
        while (resultSet.next()) {
            employee = new Employee();
            int empId = resultSet.getInt("emp_id");
            String empName = resultSet.getString("emp_name");
            double empSalary = resultSet.getDouble("emp_salary");
            int empAge = resultSet.getInt("emp_age");

            employee.setEmpId(empId);
            employee.setEmpName(empName);
            employee.setEmpSalary(empSalary);
            employee.setEmpAge(empAge);

            System.out.println(employee.toString());

//            employeeList.add(employee);

        }

        for (Employee employee1 : employeeList) {
            System.out.println(employee1.toString());
        }

        // 6. Release resources
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testReturnPK() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu", "root", "abc123");
        // Prepare the SQL statement and enable generated key return
        String sql = "INSERT INTO t_emp(emp_name, emp_salary, emp_age) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(
                sql,
                Statement.RETURN_GENERATED_KEYS
        );

// Create an Employee object and use its field values
// to fill in the placeholders in the SQL statement
        Employee employee = new Employee(null, "jack", 123.45, 29);
        preparedStatement.setString(1, employee.getEmpName());
        preparedStatement.setDouble(2, employee.getEmpSalary());
        preparedStatement.setInt(3, employee.getEmpAge());

// Execute the SQL statement and get the number of affected rows
        int result = preparedStatement.executeUpdate();
        ResultSet resultSet = null;
// Process the result
        if (result > 0) {
            System.out.println("Insert successful!");

            // Get the auto-generated primary key
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int empId = generatedKeys.getInt(1);
                employee.setEmpId(empId);   // Set the generated primary key back to the object
                System.out.println("Generated empId: " + empId);
            }

            generatedKeys.close();

            // Print the complete employee object after key backfilling
            System.out.println(employee);
        } else {
            System.out.println("Insert failed!");
        }

// Release resources
        if(resultSet!=null){
          resultSet.close();
        }

        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testMoreInsert() throws SQLException {
        // 2. Get the database connection
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql:///atguigu?rewriteBatchedStatements=true",
                "root",
                "abc123"
        );

// 3. Write the SQL statement
        String sql = "insert into t_emp (emp_name,emp_salary,emp_age) values (?,?,?)";

// 4. Create the PreparedStatement object and pass in the SQL statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

// 5. Turn off auto-commit to improve batch performance
        connection.setAutoCommit(false);

// Record the current execution start time in milliseconds
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            // 6. Assign values to the placeholders
            preparedStatement.setString(1, "marry" + i);
            preparedStatement.setDouble(2, 100.0 + i);
            preparedStatement.setInt(3, 20 + i);

            // 7. Add the current operation to the batch
            preparedStatement.addBatch();

            // Execute the batch every 500 records
            if ((i + 1) % 500 == 0) {
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
        }

// 8. Execute the remaining records
        preparedStatement.executeBatch();
        preparedStatement.clearBatch();

// 9. Commit the transaction
        connection.commit();

        long end = System.currentTimeMillis();

        System.out.println("Execution time: " + (end - start));

// 10. Release resources
        preparedStatement.close();
        connection.close();
    }

}
