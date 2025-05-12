package Lesson3;

public class Manager extends Employee {
    private String deptName;

    public String getDeptName() {
        return deptName;
    }

public Manager(int EmpId, String name, String ssn, double salary){
    super(EmpId, name, ssn, salary);
    this.deptName = deptName;
}
}
