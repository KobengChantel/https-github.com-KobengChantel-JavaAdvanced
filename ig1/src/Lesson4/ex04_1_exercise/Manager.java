package Lesson4.ex04_1_exercise;

// This class defines a Manager who extends Employee2 and adds a department name with customized printInfo output.

public class Manager extends Employee2 {
    // Field to store the manager's department name
    private String deptName;

    // Constructor initializes the employee fields and the department name
    Manager(String name, int age, double salary, String deptName) {
        super(name, age, salary);
        this.deptName = deptName;
    }

    // Getter for department name
    public String getDeptName() {
        return deptName;
    }

    // Setter for department name
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    // Override printInfo to include department information
    @Override
    public String printInfo() {
        return super.printInfo() + " Dept: " + deptName;
    }
}
