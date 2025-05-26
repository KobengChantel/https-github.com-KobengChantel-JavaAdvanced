package Lesson17;

import java.util.List;

public class NewStyleLoopTest {
    public static void main(String[] args) {

        List<Employee> eList = Employee.createShortList();
        //using streams (lazy methods) insteadof forEach loops
        //streams print results on demand (reactive)
        double result = eList.stream()
                .filter(e -> e.getState().equals("CO"))
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .peek(e -> e.printSummary())
                //converts salary to double data type
                .mapToDouble(e -> e.getSalary())
                .sum();

        System.out.printf("Total CO Executive Pay: $%,9.2f %n", result);
    }
}
