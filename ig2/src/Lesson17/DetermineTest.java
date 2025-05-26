package Lesson17;

import java.util.List;

public class DetermineTest {
    public static void main(String[] args) {

        List<Employee> eList = Employee.createShortList();

        double r1 = eList.stream()
                .filter(e -> e.getState().equals("CO"))
                .mapToDouble(Employee::getSalary)
                .sequential().sum();

        double r2 = eList.stream()
                .filter(e -> e.getState().equals("CO"))
                .mapToDouble(Employee::getSalary)
                .parallel().sum();
        //the sum of both streams is the same
        System.out.println("The same: " + (r1 == r2));
    }
}
