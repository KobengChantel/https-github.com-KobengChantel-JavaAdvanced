package Lesson17;

import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class CodeStreamTest {
    public static void main(String[] args) {

        List<Employee> eList = Employee.createShortList();
        //creating streams of type Employee instead of converting eList to a stream
        //PIPELINE creating stream from another stream
        Stream<Employee> s1 = eList.stream();

        Stream<Employee> s2 = s1.filter(
                e -> e.getState().equals("CO"));

        Stream<Employee> s3 = s2.filter(
                e -> e.getRole().equals(Role.EXECUTIVE));
        Stream<Employee> s4 = s3.peek(e -> e.printSummary());
        //double stream to convert salary to double
        DoubleStream s5 = s4.mapToDouble(e -> e.getSalary());
        double result = s5.sum();

        System.out.printf("Total CO Executive Pay: $%,9.2f %n", result);
    }
}
