package chapter14_NIO_2.examples.EmployeeSearch;

import java.util.ArrayList;

/**
 *
 * @author oracle
 */
public class A01RemoveIf {
  public static void main(String[] args) {
    // Create a list of employees from a predefined method `createShortList`
    ArrayList<Employee> eList =
            (ArrayList) Employee.createShortList(); // Explicit cast to ArrayList

    // Print a message to indicate the start of the initial list
    System.out.println("=== Starting List ===");
    // Iterate over the employee list and print a summary of each employee
    eList.forEach(Employee::printSummary);

    // Remove employees from the list whose state is "KS"
    eList.removeIf(e -> e.getState().equals("KS"));
    // The removeIf method takes a lambda predicate that specifies the condition.
    // In this case, it checks if the state of the employee equals "KS".

    // Print a message to indicate the end of the modified list
    System.out.println("=== Ending List ===");
    // Iterate over the modified employee list and print a summary of each remaining employee
    eList.forEach(Employee::printSummary);
  }
}
