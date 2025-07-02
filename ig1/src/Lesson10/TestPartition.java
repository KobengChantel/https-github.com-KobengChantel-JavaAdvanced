package Lesson10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestPartition {
    public static void main(String[] args) {
        List<Employee> eList = Employee.createShortList();

        Map<Boolean, List<Employee>> gMap = new HashMap<>();

        // Collect CO Executives
        //false result goes under its own list and the same happens for true
        //map doesn't take primitive types in its angle brackets
        gMap = eList.stream()
                .collect(
                        Collectors.partitioningBy(
                                e -> e.getRole().equals(Role.EXECUTIVE)));

        System.out.println("\n== Are there any Executives in our Employee List? ==");
        gMap.forEach((k,v) -> {
            System.out.println("\nExecutives: " + k);
            v.forEach(Employee::printSummary);
        });
    }
}
