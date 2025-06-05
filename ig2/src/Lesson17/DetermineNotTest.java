package Lesson17;

import java.util.List;
import java.util.Optional;

// This class demonstrates the difference between sequential and parallel streams when using findAny() to retrieve an element.
public class DetermineNotTest {
    public static void main(String[] args) {

        // Get a list of employees
        List<Employee> eList = Employee.createShortList();

        // Sequential stream filtering executives and finding any matching employee
        Optional<Employee> e1 = eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .sequential() // explicitly sequential (default for stream())
                .findAny();

        // Parallel stream filtering executives and finding any matching employee
        Optional<Employee> e2 = eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .parallel() // parallel processing
                .findAny();

        // Because parallel streams may return any matching element, the results may differ
        System.out.println("The same: " +
                e1.get().getEmail().equals(e2.get().getEmail()));
    }
}
