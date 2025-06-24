package Lesson3;

// This class tests the mutability of the Employee class by changing the employee's name and salary.

public class ImmutabilityTest {
    public static void main(String[] args) {

        // Create an Employee object using the constructor
        Employee emp = new Employee(1, "Jada", "12345", 4000.0);

        // Display the current salary
        System.out.println(emp.getName() + "'s current salary R" + emp.getSalary());

        // Increase the salary
        emp.raiseSalary(5000.00);

        // Display the new salary
        System.out.println(emp.getName() + "'s increased salary R" + emp.getSalary());

        // Change the employee's name
        emp.changeName("Hazel");
    }
}
