package Lesson4.ex04_1_exercise;

// This class defines a Director who is a specialized Manager and inherits behavior from the Manager class.

public class Director extends Manager {
    // Constructor calls the parent Manager constructor with the necessary parameters
    Director(String name, int age, double salary, String deptName) {
        super(name, age, salary, deptName);
    }

    // Override the printInfo method to allow customization or reuse of Manager's printInfo method
    @Override
    public String printInfo() {
        return super.printInfo();
    }
}
