package Lesson3.ex03_1_exercise;

// This class defines a Manager who inherits from Employee2 and includes an additional field for department name.

public class Manager extends Employee2 {
    // Field to store the department name
    private String deptName;

    // Constructor that calls the superclass constructor and sets the department name
    Manager(String name, int age, double salary, String deptName) {
        super(name, age, salary); // Call to Employee2 constructor
        this.deptName = deptName;
    }

    // Getter method for department name
    public String getDeptName() {
        return deptName;
    }

    // Setter method for department name
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
