package Lesson9.ex09_2_exercise;

import java.util.List;
import java.util.function.ToDoubleFunction;

// This class demonstrates how to use a lambda with ToDoubleFunction to calculate an employee's bonus based on their role.

public class FunctionTest {

  public static void main(String[] args) {

    // Get a sample list of employees
    List<Employee> eList = Employee.createShortList();

    // Select the first employee from the list
    Employee first = eList.get(0);

    // Lambda expression that calculates bonus: salary * bonus percentage based on role
    ToDoubleFunction<Employee> eFunc = e -> e.getSalary() * Bonus.byRole(e.getRole());

    // Print the summary of the first employee
    System.out.println("=== First Employee Bonus");
    first.printSummary();

    // Apply the function and print the calculated bonus
    System.out.println("Bonus: " + eFunc.applyAsDouble(first));
  }
}
