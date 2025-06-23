package Lesson4.ex04_2_exercise;

// This class represents a Director, a specialized Manager, inheriting all Manager properties and behavior.

public class Director extends Manager {
    // Constructor passing parameters up to Manager
    Director(String name, int age, double salary, String deptName) {
        super(name, age, salary, deptName);
    }

    // Override printInfo; currently just calls the parent's method but can be customized later
    @Override
    public String printInfo() {
        return super.printInfo();
    }
}
