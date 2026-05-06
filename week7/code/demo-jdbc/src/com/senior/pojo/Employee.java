package com.senior.pojo;

/*
 * This class is an entity class (or JavaBean).
 * It is used to represent one row of data in the employee table.
 */
public class Employee {

    // The employee ID.
    // In the database, the column name is emp_id.
    // In Java, we usually use camelCase, so it becomes empId.
    private Integer empId;

    // The employee name.
    // The database column emp_name corresponds to the Java field empName.
    private String empName;

    // The employee salary.
    // The database column emp_salary corresponds to the Java field empSalary.
    private Double empSalary;

    // The employee age.
    // The database column emp_age corresponds to the Java field empAge.
    private Integer empAge;

    // No-argument constructor.
    // It is often required by frameworks and is convenient when creating an empty object first.
    public Employee() {
    }

    // Full-argument constructor.
    // It allows us to create an Employee object and initialize all fields at once.
    public Employee(Integer empId, String empName, Double empSalary, Integer empAge) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.empAge = empAge;
    }

    // Getter method for empId.
    // It is used to get the employee ID.
    public Integer getEmpId() {
        return empId;
    }

    // Getter method for empName.
    // It is used to get the employee name.
    public String getEmpName() {
        return empName;
    }

    // Getter method for empSalary.
    // It is used to get the employee salary.
    public Double getEmpSalary() {
        return empSalary;
    }

    // Getter method for empAge.
    // It is used to get the employee age.
    public Integer getEmpAge() {
        return empAge;
    }

    // Setter method for empId.
    // It is used to assign a value to the employee ID.
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    // Setter method for empName.
    // It is used to assign a value to the employee name.
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    // Setter method for empSalary.
    // It is used to assign a value to the employee salary.
    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }

    // Setter method for empAge.
    // It is used to assign a value to the employee age.
    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    // Override the toString() method.
    // This makes it easier to print the object and view its field values clearly.
    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                ", empAge=" + empAge +
                '}';
    }
}