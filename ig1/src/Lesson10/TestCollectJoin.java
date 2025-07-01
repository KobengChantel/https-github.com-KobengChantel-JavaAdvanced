package Lesson10;

import java.util.List;
import java.util.stream.Collectors;

public class TestCollectJoin {
    public static void main(String[] args) {
        List<Employee> eList = Employee.createShortList();

        String dept = eList.stream()
                .map(Employee::getDept)
                .distinct()
                //converts data into a string
                .collect(Collectors.joining(", "));

        System.out.println("\n===Departments===");
        System.out.println("Total: " + dept);
    }
}
