package com.senior.dao.impl;

import com.senior.dao.BaseDao;
import com.senior.dao.EmployeeDao;
import com.senior.pojo.Employee;

import java.util.List;

// EmployeeDao implementation class
// It is responsible for CRUD operations on the t_emp table
public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {

    @Override
    public List<Employee> selectAll() {
        try {
            // Query all employee records
            // Use column aliases so that they match the field names in Employee
            String sql = "SELECT emp_id empId,emp_name empName,emp_salary empSalary,emp_age empAge FROM t_emp";
            return executeQuery(Employee.class, sql, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee selectByEmpId(Integer empId) {
        try {
            // Query one employee record by empId
            String sql = "SELECT emp_id empId,emp_name empName,emp_salary empSalary,emp_age empAge FROM t_emp where emp_id = ?";
            return executeQueryOne(Employee.class, sql, empId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int insert(Employee employee) {
        try {
            // Insert a new employee record
            String sql = "INSERT INTO t_emp(emp_name,emp_salary,emp_age) VALUES (?,?,?)";
            return executeUpdate(sql, employee.getEmpName(), employee.getEmpSalary(), employee.getEmpAge());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Employee employee) {
        try {
            // Update the salary of an employee by empId
            String sql = "UPDATE t_emp SET emp_salary = ? WHERE emp_id = ?";
            return executeUpdate(sql, employee.getEmpSalary(), employee.getEmpId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteByEmpId(Integer empId) {
        try {
            // Delete an employee record by empId
            String sql = "delete from t_emp where emp_id = ?";
            return executeUpdate(sql, empId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}