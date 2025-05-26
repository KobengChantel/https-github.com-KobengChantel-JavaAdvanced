package Lesson17;

import java.util.List;

public class ParallelTest {
    public static void main(String[] args) {

        List<Employee> eList = Employee.createShortList();

        //parallel isn't always faster
        //splits tasks up, executes themand then comes together to display results
        System.out.println("\nPARALLEL STREAM");
        double result = eList.parallelStream()
                .filter(e -> e.getState().equals("CO"))
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .peek(e -> e.printSummary())
                .mapToDouble(e -> e.getSalary())
                .sum();

        System.out.printf("Total CO Executive Pay: $%,9.2f %n", result);

        //System.out.println("\n");

        // Call parallel from pipeline
        System.out.println("\nCALLING PARALLEL FROM PIPELINE");
        result = eList.stream()
                .filter(e -> e.getState().equals("CO"))
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .peek(e -> e.printSummary())
                .mapToDouble(e -> e.getSalary())
                .parallel()
                .sum();

        System.out.printf("Total CO Executive Pay: $%,9.2f %n", result);

        //System.out.println("\n");

        // Call sequential from pipeline
        System.out.println("\nCALLING SEQUENTIAL FROM PIPELINE");
        result = eList.stream()
                .filter(e -> e.getState().equals("CO"))
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .peek(e -> e.printSummary())
                .mapToDouble(e -> e.getSalary())
                .sequential()
                .sum();

        System.out.printf("Total CO Executive Pay: $%,9.2f %n", result);
    }
}
