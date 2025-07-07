package Lesson10;

import java.util.List;
import java.util.Optional;

/**
 * Demonstrates the lazy evaluation behavior of Java Streams by
 * using peek() to print debug statements as the stream processes
 * employees, then finds and prints the first EXECUTIVE from Colorado.
 */
public class TestFindFirstLazy {
    public static void main(String[] args) {
        // Create a list of sample employees
        List<Employee> eList = Employee.createShortList();

        // Uncomment this block to print bonus paid for all CO executives:
        /*
        eList.stream()
                .peek(e -> System.out.println("Stream Start"))
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .peek(e -> System.out.println("Executives"))
                .filter(e -> e.getState().equals("CO"))
                .peek(e -> System.out.println("CO Executives"))
                .map(e -> e.getSalary() * Bonus.byRole(e.getRole()))
                .forEach(s -> System.out.printf("Bonus paid: $%,6.2f %n", s));
        */

        // Stream pipeline with peek() calls to show lazy evaluation steps,
        // finding the first EXECUTIVE employee from Colorado
        Optional<Employee> result = eList.stream()
                .peek(e -> System.out.println("Stream Start"))
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .peek(e -> System.out.println("Executives"))
                .filter(e -> e.getState().equals("CO"))
                .peek(e -> System.out.println("CO Executives"))
                .findFirst();

        // Print the employee found if any
        result.ifPresent(Employee::print);
    }
}
