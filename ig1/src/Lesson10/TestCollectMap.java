package Lesson10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestCollectMap {
    public static void main(String[] args) {
        List<Employee> eList = Employee.createShortList();

        Map<String, String> gMap = new HashMap<>();
        Map<String, List<Employee>> deptMap = new HashMap<>();

        gMap = eList.stream()
                //:: is method reference (can be substituted with lambda)
                .collect(Collectors.toMap(Employee::getEmail,
                        e -> e.getDept()));

        System.out.println("\n== Employee Information ==");
        gMap.forEach((k,v) -> {
            System.out.println("\nEmail Address: " + k + "\nDepartment Name: " + v);
            ;
        });
    }
}
