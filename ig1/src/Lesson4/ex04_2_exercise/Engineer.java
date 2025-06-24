package Lesson4.ex04_2_exercise;

// This class defines an Engineer as a subclass of Employee2 with an additional method specific to engineers.

public class Engineer extends Employee2 {
    // Constructor calls the superclass constructor to set name, age, and salary
    Engineer(String name, int age, double salary) {
        super(name, age, salary);
    }

    // Method specific to Engineer class
    public void engineerMethod() {
        System.out.println("Method specific to Engineer class");
    }
}
