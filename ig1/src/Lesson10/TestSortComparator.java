package Lesson10;

import java.util.Comparator;
import java.util.List;

/**
 * Demonstrates sorting employees using Comparator in three ways:
 * 1. By surname ascending for CO executives,
 * 2. By surname descending for CO executives,
 * 3. Two-level sort by department, then surname.
 */
public class TestSortComparator {
    public static void main(String[] args) {
        // Create a list of sample employees
        List<Employee> eList = Employee.createShortList();

        System.out.println("\n== CO Bonus Details Comparator ==");

        // Sort CO executives by surname ascending and print summary
        eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .filter(e -> e.getState().equals("CO"))
                .sorted(Comparator.comparing(Employee::getSurName))
                .forEach(Employee::printSummary);

        System.out.println("\n== CO Bonus Details Reversed ==");

        // Sort CO executives by surname descending and print summary
        eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .filter(e -> e.getState().equals("CO"))
                .sorted(Comparator.comparing(Employee::getSurName).reversed())
                .forEach(Employee::printSummary);

        System.out.println("\n== Two Level Sort, Dept then Surname ==");

        // Sort all employees by department, then surname, and print summary
        eList.stream()
                .sorted(
                        Comparator.comparing(Employee::getDept)
                                .thenComparing(Employee::getSurName))
                .forEach(Employee::printSummary);
    }
}
