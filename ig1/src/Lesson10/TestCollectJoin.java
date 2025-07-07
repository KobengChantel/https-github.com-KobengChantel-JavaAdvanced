package Lesson10;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates how to collect distinct department names from
 * a list of employees and join them into a single comma-separated string.
 */
public class TestCollectJoin {
    public static void main(String[] args) {
        // Create a list of sample employees
        List<Employee> eList = Employee.createShortList();

        // Extract distinct department names and join them as a comma-separated string
        String dept = eList.stream()
                .map(Employee::getDept)    // Map employees to their department names
                .distinct()               // Keep only unique departments
                .collect(Collectors.joining(", ")); // Join them into a single string

        System.out.println("\n===Departments===");
        System.out.println("Total: " + dept);
    }
}
