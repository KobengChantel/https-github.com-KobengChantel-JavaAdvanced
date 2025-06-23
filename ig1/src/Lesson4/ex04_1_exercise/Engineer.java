package Lesson4.ex04_1_exercise;

// This class defines an Engineer who inherits from Employee2 and uses the base employee fields and methods.

public class Engineer extends Employee2 {
    // Constructor that passes the parameters to the Employee2 constructor
    Engineer(String name, int age, double salary) {
        super(name, age, salary);
    }

    // Optionally override printInfo() to customize output for Engineer
    @Override
    public String printInfo() {
        return "Engineer - " + super.printInfo();
    }
}
