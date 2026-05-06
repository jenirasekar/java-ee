package com.senior.dao;

import com.senior.pojo.Employee;

import java.util.List;

public interface EmployeeDao {

    /**
     * Query all employee records in the table.
     *
     * @return all employee data
     */
    List<Employee> selectAll();

    /**
     * Query a single employee record by empId.
     *
     * @param empId employee id
     * @return the employee object
     */
    Employee selectByEmpId(Integer empId);

    /**
     * Insert a new employee record.
     *
     * @param employee employee object
     * @return number of affected rows
     */
    int insert(Employee employee);

    /**
     * Update an employee record by empId.
     *
     * @param employee employee object
     * @return number of affected rows
     */
    int update(Employee employee);

    /**
     * Delete an employee record by empId.
     *
     * @param empId employee id
     * @return number of affected rows
     */
    int deleteByEmpId(Integer empId);
}