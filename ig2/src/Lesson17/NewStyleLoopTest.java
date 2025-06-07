package Lesson17;

import java.util.List;

/**
 * Demonstrates usage of Java Streams to filter and process a list of Employees.
 * Specifically, it calculates the total salary of executives located in Colorado (state = "CO").
 */
public class NewStyleLoopTest {
    public static void main(String[] args) {

        // Obtain a sample list of employees
        List<Employee> eList = Employee.createShortList();

        // Use Java Streams to process the employee list in a functional style
        // Streams perform lazy evaluation, processing elements only as needed

        double result = eList.stream()
                // Filter employees whose state is "CO"
                .filter(e -> e.getState().equals("CO"))
                // Further filter employees whose role is EXECUTIVE
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                // Peek allows performing a side effect (printing summary) without modifying the stream
                .peek(e -> e.printSummary())
                // Convert the stream of Employee to a DoubleStream of their salaries
                .mapToDouble(e -> e.getSalary())
                // Sum all the salaries in the resulting stream
                .sum();

        // Print the total salary sum formatted with commas and two decimals
        System.out.printf("Total CO Executive Pay: $%,9.2f %n", result);
    }
}
