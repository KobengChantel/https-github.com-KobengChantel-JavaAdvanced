package Lesson17;

import java.util.List;
import java.util.Optional;

public class DetermineNotTest {
    public static void main(String[] args) {

        List<Employee> eList = Employee.createShortList();

        Optional<Employee> e1 = eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .sequential().findAny();

        Optional<Employee> e2 = eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .parallel().findAny();
        //could possibly be false as parallels don't operate sequentially
        System.out.println("The same: " +
                e1.get().getEmail().equals(e2.get().getEmail()));

    }
}
