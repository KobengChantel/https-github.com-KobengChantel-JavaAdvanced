package Lesson5;

public class Employee {

    private int empId;
    private String name;
    private String ssn;
    private double salary;

    public Employee(int empId, String name, String ssn, double salary) {
        this.empId = empId;
        this.name = name;
        this.ssn = ssn;
        this.salary = salary;
    }

    public String getDetails() {
        return "ID: " + empId + " Name: " + name;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getAllDetails() {
        return "ID: " + empId + " Name: " + name
                + " SSN: " + ssn + " Salary: " + salary;
    }

    public double getSalary(){
        return this.salary;
    }

    @Override
    public String toString() {
        return this.name + " earns R" + this.salary;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o != null && (o instanceof Employee)) {
            //making o an instance of Employee
            Employee e = (Employee) o;
            //checking each fields value
            if ((e.empId == this.empId)
                    && (e.name == this.name)
                    && (e.ssn == this.ssn)
                    && (e.salary == this.salary)) {
                result = true;
            }
        }
        return result;
    }
}
