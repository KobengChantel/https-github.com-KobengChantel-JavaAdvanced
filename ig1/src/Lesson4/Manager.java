package Lesson4;

// This class extends Employee by adding a department name and overrides getDetails to include it.

public class Manager extends Employee {
    // Manager's department
    private String deptName;

    // Getter for department name
    public String getDeptName() {
        return deptName;
    }

    // Setter for department name
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    // Constructor initializes Employee fields and adds department
    public Manager(int empId, String name, String ssn, double salary, String dept) {
        super(empId, name, ssn, salary); // Call parent constructor
        deptName = dept;
    }

    // Override getDetails to include department information
    @Override
    public String getDetails() {
        return super.getAllDetails() + " Dept: " + deptName;
    }
}
