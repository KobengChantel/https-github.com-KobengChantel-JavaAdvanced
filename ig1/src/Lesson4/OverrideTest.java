package Lesson4;

// This program demonstrates creating Manager and Employee objects and printing their details using overridden methods.

public class OverrideTest {
    public static void main(String[] args) {
        // Create a Manager object with id, name, ssn, salary, and department
        Manager mgr = new Manager(151, "Tom", "444-44-4444", 8000, "admin");

        // Create an Employee object with id, name, ssn, and salary
        Employee emp = new Employee(400, "Betty", "20202-785933", 6000);

        // Print details of the Manager using the getDetails method (likely overridden)
        System.out.println("Type Manager\n" + mgr.getDetails());

        System.out.println();

        // Print details of the Employee using the getAllDetails method
        System.out.println("Type Employee\n" + emp.getAllDetails());
    }
}
