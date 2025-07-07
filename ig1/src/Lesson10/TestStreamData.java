package Lesson10;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Demonstrates common stream operations to count employees,
 * find highest paid executive, and find lowest paid staff.
 */
public class TestStreamData {
    public static void main(String[] args) {
        // Create a list of sample employees
        List<Employee> eList = Employee.createShortList();

        System.out.println("\n== Executive Count ==");
        // Count how many employees have the EXECUTIVE role
        long execCount =
                eList.stream()
                        .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                        .count();
        System.out.println("Exec count: " + execCount);

        System.out.println("\n== Highest Paid Exec ==");
        // Find the executive with the highest salary
        Optional<Employee> highestExec =
                eList.stream()
                        .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                        .max(Employee::sortBySalary);

        highestExec.ifPresent(temp ->
                System.out.printf(
                        "Name: %s %s   Salary: $%,6.2f %n",
                        temp.getGivenName(), temp.getSurName(), temp.getSalary()));

        System.out.println("\n== Lowest Paid Staff ==");
        // Find the staff member with the lowest salary
        Optional<Employee> lowestStaff =
                eList.stream()
                        .filter(e -> e.getRole().equals(Role.STAFF))
                        .min(Comparator.comparingDouble(Employee::getSalary));

        lowestStaff.ifPresent(temp ->
                System.out.printf(
                        "Name: %s %s   Salary: $%,6.2f %n",
                        temp.getGivenName(), temp.getSurName(), temp.getSalary()));
    }
}
