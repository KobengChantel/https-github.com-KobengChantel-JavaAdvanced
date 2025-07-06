package Lesson10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Demonstrates grouping employees by their department into a map,
 * then printing summary information for employees in each department.
 */
public class TestCollectGroup {
    public static void main(String[] args) {
        // Create a list of sample employees
        List<Employee> eList = Employee.createShortList();

        // Map to hold department names as keys and lists of employees as values
        Map<String, List<Employee>> gMap = new HashMap<>();

        // Group employees by department using a stream collector
        gMap = eList.stream()
                .collect(Collectors.groupingBy(Employee::getDept));

        System.out.println("\n--Employees per Department--");

        // Iterate over each department and print summaries of employees
        gMap.forEach((k, v) -> {
            System.out.println("\nDepartment: " + k);
            v.forEach(Employee::printSummary);
        });
    }
}
