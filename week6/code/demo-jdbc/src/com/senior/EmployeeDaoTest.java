package com.senior;

import com.senior.dao.EmployeeDao;
import com.senior.dao.impl.EmployeeDaoImpl;
import com.senior.pojo.Employee;
import org.junit.Test;

import java.util.List;

public class EmployeeDaoTest {

    // Create the DAO object
    private final EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Test
    public void testSelectAll() {
        List<Employee> list = employeeDao.selectAll();

        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    @Test
    public void testSelectByEmpId() {
        Employee employee = employeeDao.selectByEmpId(1);
        System.out.println(employee);
    }

    @Test
    public void testInsert() {
        Employee employee = new Employee(null, "Tom", 8888.88, 25);

        int rows = employeeDao.insert(employee);
        System.out.println("Affected rows: " + rows);
    }

    @Test
    public void testUpdate() {
        // Make sure the empId exists in the database before running this test
        Employee employee = new Employee(1, null, 9999.99, null);

        int rows = employeeDao.update(employee);
        System.out.println("Affected rows: " + rows);
    }

    @Test
    public void testDeleteByEmpId() {
        // Make sure the empId exists in the database before running this test
        int rows = employeeDao.deleteByEmpId(1);
        System.out.println("Affected rows: " + rows);
    }
}