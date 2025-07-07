package Lesson10;

import java.util.List;
import java.util.Optional;

/**
 * Demonstrates using Stream.findFirst() to get the first EXECUTIVE employee
 * located in Colorado ("CO") and print their details if present.
 */
public class TestFindFirst {
    public static void main(String[] args) {
        // Create a list of sample employees
        List<Employee> eList = Employee.createShortList();

        // Use Optional to safely hold the result, which may or may not be present
        Optional<Employee> result = eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))   // Filter for EXECUTIVE role
                .filter(e -> e.getState().equals("CO"))             // Filter for Colorado state
                .findFirst();                                        // Get first matching employee

        // If employee is found, print details
        result.ifPresent(Employee::print);
    }
}
