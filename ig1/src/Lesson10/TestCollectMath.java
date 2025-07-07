package Lesson10;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates calculating the average salary of EXECUTIVE employees
 * located in Colorado (state "CO") using Collectors.averagingDouble().
 */
public class TestCollectMath {
    public static void main(String[] args) {
        // Create a list of sample employees
        List<Employee> eList = Employee.createShortList();

        // Calculate average salary of executives from Colorado
        double avgSalary = eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))   // Filter executives
                .filter(e -> e.getState().equals("CO"))             // Filter those in CO
                .collect(Collectors.averagingDouble(Employee::getSalary)); // Average salary

        System.out.println("\n==CO Executive Average Salary==");
        System.out.printf("Average Salary: $%,9.2f %n", avgSalary);
    }
}
