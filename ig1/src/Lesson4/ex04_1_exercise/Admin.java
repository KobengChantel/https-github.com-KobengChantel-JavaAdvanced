package Lesson4.ex04_1_exercise;

// This class defines an Admin as a type of Employee2 without any extra properties.

public class Admin extends Employee2 {
    // Constructor calls the parent Employee2 constructor
    Admin(String name, int age, double salary) {
        super(name, age, salary);
    }
}
