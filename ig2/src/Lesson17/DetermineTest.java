package Lesson17;

import java.util.List;

// This class shows that summing salaries of employees filtered by state gives the same result whether done sequentially or in parallel.
public class DetermineTest {
    public static void main(String[] args) {

        // Get a list of employees
        List<Employee> eList = Employee.createShortList();

        // Sequentially sum salaries of employees from Colorado ("CO")
        double r1 = eList.stream()
                .filter(e -> e.getState().equals("CO"))
                .mapToDouble(Employee::getSalary)
                .sequential()  // explicitly sequential (default for stream)
                .sum();

        // Parallel sum of salaries of employees from Colorado
        double r2 = eList.stream()
                .filter(e -> e.getState().equals("CO"))
                .mapToDouble(Employee::getSalary)
                .parallel()  // parallel processing
                .sum();

        // Print whether both sums are equal (they should be)
        System.out.println("The same: " + (r1 == r2));
    }
}
