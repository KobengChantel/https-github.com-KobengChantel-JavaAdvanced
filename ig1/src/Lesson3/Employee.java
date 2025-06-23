package Lesson3;

// This class represents an employee with ID, name, social security number (SSN), and salary, along with methods to access and modify this data.

public class Employee {
    // Fields to store employee ID, name, SSN, and salary
    private int empId;
    private String name;
    private String ssn;
    private double salary;

    // Constructor to initialize all fields
    public Employee(int empId, String name, String ssn, double salary) {
        this.empId = empId;
        this.name = name;
        this.ssn = ssn;
        this.salary = salary;
    }

    // Getter method for employee name
    public String getName() {
        return name;
    }

    // Getter method for social security number
    public String getSsn() {
        return ssn;
    }

    // Getter method for salary
    public double getSalary() {
        return salary;
    }

    // Getter method for employee ID
    public int getEmpId() {
        return empId;
    }

    // Method to change the employee's name
    public void changeName(String newName) {
        if (newName != null) {
            this.name = newName;
        }
    }

    // Method to increase the employee's salary by a given amount
    public void raiseSalary(double increase) {
        this.salary += increase;
    }
}
