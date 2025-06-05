package Lesson17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// This class demonstrates the difference between a stateful (incorrect)
// and stateless (correct) way to filter a list using parallel streams.
public class AvoidStatefulTest {
    public static void main(String[] args) {

        // Create a sample list of employees
        List<Employee> eList = Employee.createShortList();

        // Lists to store filtered results
        List<Employee> newList01 = new ArrayList<>();
        List<Employee> newList02 = new ArrayList<>();

        // BAD PROGRAMMING: Using forEach to add elements to a shared list during parallel stream processing
        // This is not thread-safe and can lead to unpredictable results.
        eList.parallelStream()  // parallel stream
                .filter(e -> e.getDept().equals("Eng")) // filter employees in Engineering dept
                .forEach(e -> newList01.add(e)); // adding elements to shared mutable list - not safe!

        // GOOD PROGRAMMING: Using collect() to safely gather results from parallel stream
        // This approach avoids shared mutable state and is thread-safe.
        newList02 = eList.parallelStream()
                .filter(e -> e.getDept().equals("Eng"))
                .collect(Collectors.toList()); // collect results into a new list safely
    }
}
