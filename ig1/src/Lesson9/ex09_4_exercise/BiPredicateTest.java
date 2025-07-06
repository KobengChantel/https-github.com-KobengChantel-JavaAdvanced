package Lesson9.ex09_4_exercise;

import java.util.List;
import java.util.function.BiPredicate;

/**
 * Demonstrates the use of a BiPredicate functional interface to filter employees by state.
 */
public class BiPredicateTest {

  public static void main(String[] args) {

    // Create a sample list of employees
    List<Employee> eList = Employee.createShortList();

    // Get the first employee in the list (not used further here)
    Employee first = eList.get(0);

    // The state to search for
    String searchState = "KS";

    // BiPredicate that tests if an employee's state equals the provided state string
    BiPredicate<Employee, String> eBiPred = (e,s) -> e.getState().equals(s);

    // Print employees whose state matches the searchState
    System.out.println("=== Print matching list");
    for(Employee e : eList){
      if (eBiPred.test(e, searchState)){ // Use BiPredicate to test condition
        e.printSummary();
      }
    }
  }
}
