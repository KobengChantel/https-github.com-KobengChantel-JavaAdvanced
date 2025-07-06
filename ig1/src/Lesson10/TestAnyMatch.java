package Lesson10;

import java.util.List;
import java.util.Optional;

/**
 * Demonstrates the use of Stream.anyMatch() and filtering to find
 * an EXECUTIVE employee from Colorado (state "CO") and print their details.
 */
public class TestAnyMatch {
    public static void main(String[] args) {
        // Create a list of sample employees
        List<Employee> eList = Employee.createShortList();

        System.out.println("\n===First CO Bonus===");

        // Check if any employee is from Colorado ("CO")
        if (eList.stream().anyMatch(e -> e.getState().equals("CO"))) {
            // If such employee(s) exist, find the first EXECUTIVE in CO using parallel stream
            Optional<Employee> result = eList.parallelStream()
                    .peek(e -> System.out.println("Stream")) // Debug print when processing each employee
                    .filter(e -> e.getRole().equals(Role.EXECUTIVE)) // Filter only EXECUTIVE role
                    .filter(e -> e.getState().equals("CO"))          // Filter only from Colorado
                    .findFirst();

            // Print the found employee if present
            result.ifPresent(Employee::print);
        }
    }
}
