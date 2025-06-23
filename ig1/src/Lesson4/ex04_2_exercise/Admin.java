package Lesson4.ex04_2_exercise;

// This class defines an Admin as a subclass of Employee2, using only the inherited properties.

public class Admin extends Employee2 {
    // Constructor passes name, age, and salary to the superclass (Employee2)
    Admin(String name, int age, double salary) {
        super(name, age, salary);
    }
}
