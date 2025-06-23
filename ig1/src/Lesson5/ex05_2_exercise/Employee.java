package Lesson5.ex05_2_exercise;

// This class represents an Employee with personal and job details, and calculates bonus and withholding amounts using an inner helper class.

public class Employee {

    private String name;      // Employee's name
    private String role;      // Employee's job role
    private String dept;      // Employee's department
    private double salary;    // Employee's salary

    BenefitsHelper helper = new BenefitsHelper(); // Inner helper object to calculate benefits

    // Default constructor
    public Employee() {
        super();
    }

    // Parameterized constructor to initialize all fields
    public Employee(String name, String role, String dept, double salary) {
        this.name = name;
        this.role = role;
        this.dept = dept;
        this.salary = salary;
    }

    // Getter for employee name
    public String getName() {
        return name;
    }

    // Getter for employee role
    public String getRole() {
        return role;
    }

    // Getter for employee department
    public String getDept() {
        return dept;
    }

    // Getter for employee salary
    public double getSalary() {
        return salary;
    }

    // Calculate and return the bonus based on salary using BenefitsHelper
    public double getBonus() {
        return helper.calcBonus(salary);
    }

    // Calculate and return the withholding amount based on salary using BenefitsHelper
    public double getWithholding() {
        return helper.calcWithholding(salary);
    }

    // Private inner class to encapsulate bonus and withholding calculations
    private class BenefitsHelper {
        private final double bonusRate = 0.02;       // Bonus rate is 2%
        private final double withholdingRate = 0.07; // Withholding rate is 7%

        // Calculate bonus as salary multiplied by bonus rate
        protected double calcBonus(double salary) {
            return salary * bonusRate;
        }

        // Calculate withholding as salary multiplied by withholding rate
        protected double calcWithholding(double salary) {
            return salary * withholdingRate;
        }
    }

}
