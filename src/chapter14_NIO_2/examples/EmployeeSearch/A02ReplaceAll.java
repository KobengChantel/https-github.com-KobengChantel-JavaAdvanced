package chapter14_NIO_2.examples.EmployeeSearch;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author oracle
 */
public class A02ReplaceAll {
  public static void main(String[] args) {
    // Create a list of employees from a predefined method `createShortList`
    ArrayList<Employee> eList =
            (ArrayList) Employee.createShortList(); // Explicit cast to ArrayList

    // Print a message to indicate the start of the initial list
    System.out.println("=== Starting List ===");
    // Iterate over the employee list and print a summary of each employee
    eList.forEach(Employee::printSummary);

    // Replace each employee in the list with a new Employee object using replaceAll
    eList.replaceAll(e ->
            new Employee.Builder() // Using the Builder pattern to create a new Employee
                    .givenName("Bob") // Assign given name
                    .surName("Baker") // Assign surname
                    .age(23) // Assign age
                    .gender(Gender.MALE) // Assign gender
                    .role(Role.STAFF) // Assign role
                    .dept("Eng") // Assign department
                    .startDate(LocalDate.of(2013, 1, 10)) // Assign start date
                    .salary(40000) // Assign salary
                    .email("bob.baker@example.com") // Assign email
                    .phoneNumber("201-121-4678") // Assign phone number
                    .address("44 4th St") // Assign address
                    .city("Smallville") // Assign city
                    .state("KS") // Assign state
                    .code("12333") // Assign postal code
                    .build() // Build the Employee object
    );

    // Print a message to indicate the end of the modified list
    System.out.println("\n=== Ending List ===");
    // Iterate over the modified employee list and print a summary of each new employee
    eList.forEach(Employee::printSummary);
  }
}
