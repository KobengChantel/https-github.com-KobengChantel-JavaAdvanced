package Lesson10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates filtering, sorting, and collecting employees into a list,
 * then printing summary information for executives in Colorado.
 */
public class TestCollect {
    public static void main(String[] args) {

        // Create a list of sample employees
        List<Employee> eList = Employee.createShortList();

        List<Employee> nList = new ArrayList<>();

        // Collect executives from Colorado, sorted by surname
        nList = eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))      // Only executives
                .filter(e -> e.getState().equals("CO"))                // Only from Colorado
                .sorted(Comparator.comparing(Employee::getSurName))   // Sort by surname
                .collect(Collectors.toList());                         // Collect to list

        System.out.println("\n== CO Bonus Details ==");

        // Print a summary of each employee in the collected list
        nList.stream()
                .forEach(Employee::printSummary);

        // Note: The Collectors class offers many methods like joining(), averagingDouble(), groupingBy(), counting(), etc.
    }
}
