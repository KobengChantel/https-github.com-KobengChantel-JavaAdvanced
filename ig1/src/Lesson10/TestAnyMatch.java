package Lesson10;

import java.util.List;
import java.util.Optional;

public class TestAnyMatch {
    public static void main(String[] args) {
        List<Employee> eList = Employee.createShortList();

        System.out.println("\n===First CO Bonus===");

        if(eList.stream().anyMatch(e -> e.getState().equals("CO"))) {
            //if there's a match this is what we return
            Optional<Employee> result = eList.parallelStream()
                    .peek(e -> System.out.println("Stream"))
                    .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                    .filter(e -> e.getState().equals("CO"))
                    .findFirst();

            //print result if it exists
            if(result.isPresent()) {
                result.get().print();
            }
        }

    }
}
