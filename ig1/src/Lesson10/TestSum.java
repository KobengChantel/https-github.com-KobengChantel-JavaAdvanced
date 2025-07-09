package Lesson10;

import java.util.List;

/**
 * Demonstrates summing bonuses paid to EXECUTIVE employees in Colorado,
 * printing each bonus before summing the total.
 */
public class TestSum {
    public static void main(String[] args) {
        // Create a list of sample employees
        List<Employee> eList = Employee.createShortList();
        double result;

        // Calculate total bonuses for CO executives, printing each bonus
        result = eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))  // Filter executives
                .filter(e -> e.getState().equals("CO"))           // Filter Colorado state
                .peek(e -> System.out.print("Name: "
                        + e.getGivenName() + " " + e.getSurName() + " "))
                .mapToDouble(e -> e.getSalary() * Bonus.byRole(e.getRole()))  // Calculate bonus
                .peek(d -> System.out.printf("Bonus paid: $%,6.2f %n", d))    // Print each bonus
                .sum();  // Sum all bonuses

        System.out.printf("Total Bonuses paid: $%,6.2f %n", result);  // Print total bonus sum
    }
}
