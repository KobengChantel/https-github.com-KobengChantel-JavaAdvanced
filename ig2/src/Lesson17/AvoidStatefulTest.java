package Lesson17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AvoidStatefulTest {
    public static void main(String[] args) {

        List<Employee> eList = Employee.createShortList();
        List<Employee> newList01 = new ArrayList<>();
        List<Employee> newList02 = new ArrayList<>();

        //BAD PROGRAMMING
        eList.parallelStream() // Not Parallel. Bad.
                .filter(e -> e.getDept().equals("Eng"))
                //forEach is a sequential operation, doesn't parallelize
                .forEach(e -> newList01.add(e));

        newList02 = eList.parallelStream() // Good Parallel
                .filter(e -> e.getDept().equals("Eng"))
                //collects and prints to a normal list
                .collect(Collectors.toList());

    }
}

