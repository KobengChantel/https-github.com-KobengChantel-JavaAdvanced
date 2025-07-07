package Lesson10;

import java.util.List;
import java.util.Optional;

/**
 * Demonstrates the use of Optional to find the first EXECUTIVE employee
 * from Arizona ("AZ"), then print their summary or a default message if none found.
 */
public class TestOptional {
    public static void main(String[] args) {
        // Create a list of sample employees
        List<Employee> eList = Employee.createShortList();

        System.out.println("\n===First CO Bonus===");

        // Find the first EXECUTIVE from AZ, get their summary, or print a default message
        System.out.println(
                eList.stream()
                        .filter(e -> e.getRole().equals(Role.EXECUTIVE))  // Filter executives
                        .filter(e -> e.getState().equals("AZ"))            // Filter Arizona state
                        .findFirst()                                       // Get first match as Optional
                        .flatMap(e -> Optional.of(e.getSummary()))        // Map to summary wrapped in Optional
                        .orElse("No match found!")                         // Default if no match
        );
    }
}
