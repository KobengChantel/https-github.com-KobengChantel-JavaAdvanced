package Lesson9.ex09_1_exercise;

import java.util.List;
import java.util.function.Consumer;

// This class demonstrates the use of the Consumer functional interface to print details of an Employee object.

public class ConsumerTest {

  public static void main(String[] args) {

    // Create a list of sample Employee objects
    List<Employee> eList = Employee.createShortList();

    // Retrieve the first Employee from the list
    Employee first = eList.get(0);

    // Define a Consumer lambda expression that prints the Employee's surname, role, and salary
    Consumer<Employee> eCons = e -> System.out.println(
            "Name: " + e.getSurName() + "\nRole: "
                    + e.getRole() + "\nSalary: " + e.getSalary()
    );

    // Print heading
    System.out.println("=== First Salary");

    // Use the Consumer to print the details of the first Employee
    eCons.accept(first);
  }
}
