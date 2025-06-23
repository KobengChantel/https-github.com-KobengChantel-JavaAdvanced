package Lesson4;

// This class models an Employee with ID, name, SSN, and salary, and provides methods for displaying and comparing employee data.

public class Employee {
    // Employee ID
    private int empId;

    // Employee name
    private String name;

    // Social Security Number
    private String ssn;

    // Salary in Rands
    private double salary;

    // Constructor initializes all fields
    public Employee(int empId, String name, String ssn, double salary) {
        this.empId = empId;
        this.name = name;
        this.ssn = ssn;
        this.salary = salary;
    }

    // Returns only ID and name
    public String getDetails() {
        return "ID: " + empId + " Name: " + name;
    }

    // Returns all employee details
    public String getAllDetails() {
        return "ID: " + empId + " Name: " + name
                + " SSN: " + ssn + " Salary: " + salary;
    }

    // Returns the salary
    public double getSalary() {
        return this.salary;
    }

    // Custom string representation of the employee
    @Override
    public String toString() {
        return this.name + " earns R" + this.salary;
    }

    // Checks equality based on all field values
    @Override
    public boolean equals(Object o) {
        boolean result = false;

        // Make sure the object is not null and is an instance of Employee
        if (o != null && (o instanceof Employee)) {
            Employee e = (Employee) o;

            // Compare all field values for equality
            if ((e.empId == this.empId)
                    && (e.name == this.name)
                    && (e.ssn == this.ssn)
                    && (e.salary == this.salary)) {
                result = true;
            }
        }
        return result;
    }
}
