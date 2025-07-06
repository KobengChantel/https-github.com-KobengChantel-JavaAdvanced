package Lesson9.ex09_3_exercise;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Supplier;

/**
 * Demonstrates usage of the Supplier functional interface to create and add a new Employee to a list.
 */
public class SupplierTest {

  public static void main(String[] args) {

    // Get a sample list of employees
    List<Employee> eList = Employee.createShortList();

    // Reference to the first employee in the list (not used further here)
    Employee first = eList.get(0);

    // Supplier functional interface implementation using a lambda to build a new Employee object
    Supplier<Employee> eSupp =
            () -> new Employee.Builder()
                    .givenName("Jill")
                    .surName("Doe")
                    .age(26)
                    .gender(Gender.FEMALE)
                    .role(Role.STAFF)
                    .dept("Sales")
                    .startDate(LocalDate.of(2012, 7, 14))
                    .salary(45000)
                    .email("jill.doe@example.com")
                    .phoneNumber("202-123-4678")
                    .address("33 3rd St")
                    .city("Smallville")
                    .state("KS")
                    .code("12333")
                    .build();

    // Print summaries of employees before adding new one
    System.out.println("=== Print employee list before");
    eList.stream().forEach(Employee::printSummary);

    // Add new employee created by the Supplier to the list
    eList.add(eSupp.get());

    // Print summaries of employees after adding the new employee
    System.out.println("\n=== Print employee list after");
    eList.stream().forEach(Employee::printSummary);
  }
}
