package Lesson3.ex03_1_exercise;

// This program defines an Employee2 class with private fields, a constructor, and getter and setter methods for encapsulation.

public class Employee2 {
    // Private fields to store the employee's name, age, and salary
    private String name;
    private int age;
    private double salary;

    // Constructor to initialize the employee's details
    public Employee2(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Setter method for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for age
    public int getAge() {
        return age;
    }

    // Setter method for age
    public void setAge(int age) {
        this.age = age;
    }

    // Getter method for salary
    public double getSalary() {
        return salary;
    }

    // Setter method for salary
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
