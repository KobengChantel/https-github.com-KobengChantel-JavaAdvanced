package Lesson4.ex04_2_exercise;

// This class models a Manager as a specialized Employee2 who manages a specific department.

public class Manager extends Employee2 {
    // Department name managed by the manager
    private String deptName;

    // Constructor initializing inherited fields and department name
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

    // Override printInfo to include department details along with employee info
    @Override
    public String printInfo() {
        return super.printInfo() + " Dept: " + deptName;
    }
}
