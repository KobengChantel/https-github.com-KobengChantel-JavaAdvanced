package Lesson5;

// Represents an employee with ID, name, SSN, and salary, including methods to get details and compare equality.

public class Employee {

    private int empId;       // Employee ID
    private String name;     // Employee name
    private String ssn;      // Social Security Number
    private double salary;   // Employee salary

    // Constructor to initialize all fields
    public Employee(int empId, String name, String ssn, double salary) {
        this.empId = empId;
        this.name = name;
        this.ssn = ssn;
        this.salary = salary;
    }

    // Returns basic details (ID and name)
    public String getDetails() {
        return "ID: " + empId + " Name: " + name;
    }

    // Setters for each field
    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Returns all details including SSN and salary
    public String getAllDetails() {
        return "ID: " + empId + " Name: " + name
                + " SSN: " + ssn + " Salary: " + salary;
    }

    // Getter for salary
    public double getSalary() {
        return this.salary;
    }

    // Overrides toString to show employee's name and salary
    @Override
    public String toString() {
        return this.name + " earns R" + this.salary;
    }

    // Overrides equals to compare two Employee objects by all fields
    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o != null && (o instanceof Employee)) {
            // Cast the object to Employee
            Employee e = (Employee) o;
            // Check if all fields are equal (note: String comparison should use .equals)
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
