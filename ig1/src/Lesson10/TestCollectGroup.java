package Lesson10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestCollectGroup {
    public static void main(String[] args) {
        List<Employee> eList = Employee.createShortList();
        //must group by having a map to recieve data in
        Map<String, List<Employee>> gMap = new HashMap<>();

        gMap = eList.stream()
                .collect(Collectors.groupingBy(Employee::getDept));

        System.out.println("\n--Employees per Department--");
        gMap.forEach((k,v) -> {
            System.out.println("\nDepartment: " + k);
            v.forEach(Employee::printSummary);
        });
    }
}
