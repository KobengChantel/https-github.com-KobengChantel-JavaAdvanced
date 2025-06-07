package Lesson17;

import java.util.List;

/**
 * Demonstrates the use of parallel streams in Java to process collections concurrently.
 * Compares results of running stream operations in parallel and sequential modes.
 */
public class ParallelTest {
    public static void main(String[] args) {

        // Get a sample list of employees
        List<Employee> eList = Employee.createShortList();

        // Using a parallel stream directly from the list
        // Note: parallel streams split the workload across multiple threads,
        // but may not always be faster due to overhead and task nature.
        System.out.println("\nPARALLEL STREAM");
        double result = eList.parallelStream()
                // Filter employees from Colorado
                .filter(e -> e.getState().equals("CO"))
                // Further filter employees who are EXECUTIVES
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                // Print summary for each matching employee (peek is for debugging or side effects)
                .peek(e -> e.printSummary())
                // Convert stream to double stream of salaries
                .mapToDouble(e -> e.getSalary())
                // Sum all salaries
                .sum();

        // Display total pay for Colorado executives
        System.out.printf("Total CO Executive Pay: $%,9.2f %n", result);

        // Using a sequential stream but switching to parallel midway in the pipeline
        System.out.println("\nCALLING PARALLEL FROM PIPELINE");
        result = eList.stream()
                .filter(e -> e.getState().equals("CO"))
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .peek(e -> e.printSummary())
                .mapToDouble(e -> e.getSalary())
                // Switch this stream to parallel at this point
                .parallel()
                .sum();

        System.out.printf("Total CO Executive Pay: $%,9.2f %n", result);

        // Using a sequential stream but forcing sequential processing after parallel switch
        System.out.println("\nCALLING SEQUENTIAL FROM PIPELINE");
        result = eList.stream()
                .filter(e -> e.getState().equals("CO"))
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .peek(e -> e.printSummary())
                .mapToDouble(e -> e.getSalary())
                // Force stream back to sequential processing
                .sequential()
                .sum();

        System.out.printf("Total CO Executive Pay: $%,9.2f %n", result);
    }
}
