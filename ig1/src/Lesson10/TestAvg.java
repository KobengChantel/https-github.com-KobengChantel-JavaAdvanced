package Lesson10;

import java.util.List;
import java.util.OptionalDouble;

/**
 * Demonstrates calculating the average bonus paid to EXECUTIVE employees
 * from Colorado (state "CO") using Java Streams.
 */
public class TestAvg {
    public static void main(String[] args) {
        // Create a list of sample employees
        List<Employee> eList = Employee.createShortList();
        OptionalDouble result;

        System.out.println("\n== Average CO Bonus Details ==");

        // Stream pipeline to filter executives from CO, calculate their bonuses,
        // and compute the average bonus
        result = eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))      // Only executives
                .filter(e -> e.getState().equals("CO"))                // Only from Colorado
                .peek(e -> System.out.print("Name: " + e.getGivenName()
                        + " " + e.getSurName() + " "))                // Print employee name
                .mapToDouble(e -> e.getSalary() * Bonus.byRole(e.getRole())) // Calculate bonus amount
                .peek(d -> System.out.printf("Bonus paid: $%,6.2f %n", d))  // Print bonus amount
                .average();                                             // Calculate average bonus

        // If average exists, print it formatted
        if (result.isPresent()){
            System.out.printf("Average Bonuses paid: $%,6.2f %n",
                    result.getAsDouble());
        }
    }
}
