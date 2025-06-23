package Lesson4.ex04_1_exercise;

// This class represents a basic employee with fields for name, age, and salary, and includes methods to access and display this information.

public class Employee2 {
    // Fields to store employee's name, age, and salary
    private String name;
    private int age;
    private double salary;

    // Constructor to initialize the employee fields
    public Employee2(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Getter for salary
    public double getSalary() {
        return salary;
    }

    // Setter for salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Method to return formatted employee information
    public String printInfo() {
        return "Name: " + name + " Age: " + age + " Salary: " + salary;
    }
}
