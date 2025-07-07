package Lesson10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Demonstrates creating a Map from employee email addresses to their departments,
 * then printing the email and corresponding department.
 */
public class TestCollectMap {
    public static void main(String[] args) {
        // Create a list of sample employees
        List<Employee> eList = Employee.createShortList();

        Map<String, String> gMap = new HashMap<>();

        // Collect a map where key = employee email, value = employee department
        gMap = eList.stream()
                // Method reference for key (email) and lambda for value (department)
                .collect(Collectors.toMap(Employee::getEmail, e -> e.getDept()));

        System.out.println("\n== Employee Information ==");

        // Print each email and its associated department
        gMap.forEach((k, v) -> {
            System.out.println("\nEmail Address: " + k + "\nDepartment Name: " + v);
        });
    }
}
