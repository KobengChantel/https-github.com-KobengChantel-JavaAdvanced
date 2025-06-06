package Lesson17;

import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

// This class demonstrates how to create and chain
// streams to filter employees by state and role, print summaries,
// and sum their salaries.
public class CodeStreamTest {
    public static void main(String[] args) {

        // Get a list of employees
        List<Employee> eList = Employee.createShortList();

        // Create a stream from the employee list
        Stream<Employee> s1 = eList.stream();

        // Filter employees who are from Colorado (state "CO")
        Stream<Employee> s2 = s1.filter(e -> e.getState().equals("CO"));

        // Further filter those who have the role EXECUTIVE
        Stream<Employee> s3 = s2.filter(e -> e.getRole().equals(Role.EXECUTIVE));

        // Peek to print a summary of each employee passing through this stage (useful for debugging)
        Stream<Employee> s4 = s3.peek(e -> e.printSummary());

        // Convert the stream to a DoubleStream extracting salaries
        DoubleStream s5 = s4.mapToDouble(e -> e.getSalary());

        // Sum all the salaries in the filtered stream
        double result = s5.sum();

        // Print the total salary of all Colorado executives formatted as currency
        System.out.printf("Total CO Executive Pay: $%,9.2f %n", result);
    }
}
