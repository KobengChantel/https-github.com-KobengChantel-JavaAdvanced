package Lesson10;

import java.util.List;

/**
 * Demonstrates the use of Stream.peek() to display intermediate information
 * about employees before calculating and printing their bonuses.
 */
public class TestPeek {
    public static void main(String[] args) {
        // Create a list of sample employees
        List<Employee> eList = Employee.createShortList();

        System.out.println("===Bonuses===");

        eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))  // Filter executives
                .filter(e -> e.getState().equals("CO"))           // Filter those in Colorado
                // Display employee info before bonus calculation
                .peek(e -> System.out.println("\nName: " + e.getGivenName() + " " + e.getSurName() +
                        "\nSalary: " + e.getSalary() +
                        "\nBonus: " + Bonus.byRole(e.getRole())
                ))
                .map(e -> e.getSalary() * Bonus.byRole(e.getRole()))  // Calculate bonus
                .forEach(s -> System.out.printf("Bonus paid: $%,6.2f %n", s)); // Print bonus
    }
}
