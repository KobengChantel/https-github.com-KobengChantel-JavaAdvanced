package Lesson4.ex04_2_exercise;

// This class models a basic employee with name, age, and salary, providing getters, setters, and a method to print employee information.

public class Employee2 {
    // Fields to hold employee data
    private String name;
    private int age;
    private double salary;

    // Constructor initializes all fields
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

    // Returns a formatted string representing the employee's details
    public String printInfo() {
        return "Name: " + name + " Age: " + age + " Salary: " + salary;
    }
}
