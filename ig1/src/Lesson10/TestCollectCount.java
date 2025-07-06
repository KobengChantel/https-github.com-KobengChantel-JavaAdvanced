package Lesson10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Demonstrates grouping employees by department and counting
 * the number of employees in each department using Java Streams.
 */
public class TestCollectCount {
    public static void main(String[] args) {
        // Create a list of sample employees
        List<Employee> eList = Employee.createShortList();

        Map<String, Long> gMap = new HashMap<>();

        // Group employees by department and count how many in each
        gMap = eList.stream()
                .collect(
                        Collectors.groupingBy(
                                e -> e.getDept(), Collectors.counting()));

        System.out.println("\n===Employees per Department===");

        // Print the department name and employee count
        gMap.forEach((k, v) ->
                System.out.println("\nDept: " + k + "\nCount: " + v));
    }
}
