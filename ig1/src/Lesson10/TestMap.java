package Lesson10;

import java.util.List;

/**
 * Demonstrates using Stream.map() to calculate and print the bonuses
 * for EXECUTIVE employees located in Colorado.
 */
public class TestMap {
    public static void main(String[] args) {
        // Create a list of sample employees
        List<Employee> eList = Employee.createShortList();

        System.out.println("Bonuses");

        // Filter executives in Colorado, map to their bonus amounts, and print each
        eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))      // Only executives
                .filter(e -> e.getState().equals("CO"))                // Only those in Colorado
                .map(e -> e.getSalary() * Bonus.byRole(e.getRole()))  // Calculate bonus
                .forEach(s -> System.out.printf("Bonus paid: $%,6.2f %n", s)); // Print bonus
    }
}
