package Lesson10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Demonstrates partitioning employees into two groups based on whether
 * they are EXECUTIVE role or not, using Collectors.partitioningBy.
 */
public class TestPartition {
    public static void main(String[] args) {
        // Create a list of sample employees
        List<Employee> eList = Employee.createShortList();

        Map<Boolean, List<Employee>> gMap = new HashMap<>();

        // Partition employees into two groups: EXECUTIVES (true) and others (false)
        gMap = eList.stream()
                .collect(
                        Collectors.partitioningBy(
                                e -> e.getRole().equals(Role.EXECUTIVE)));

        System.out.println("\n== Are there any Executives in our Employee List? ==");

        // Print each partition group with employee summaries
        gMap.forEach((k, v) -> {
            System.out.println("\nExecutives: " + k);
            v.forEach(Employee::printSummary);
        });
    }
}
