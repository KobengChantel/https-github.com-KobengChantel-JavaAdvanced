package Lesson10;

import java.util.List;
import java.util.Optional;

public class TestFindFirstLazy {
    public static void main(String[] args) {
        List<Employee> eList = Employee.createShortList();

        //only printing exec for CO
//        eList.stream()
//                .peek(e -> System.out.println("Stream Start"))
//                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
//                .peek(e -> System.out.println("Executives"))
//                .filter(e -> e.getState().equals("CO"))
//                .peek(e -> System.out.println("CO Executives"))
//                .map(e -> e.getSalary() * Bonus.byRole(e.getRole()))
//                .forEach(s -> System.out.printf("Bonus paid: $%,6.2f %n", s));

        Optional<Employee> result = eList.stream()
                .peek(e -> System.out.println("Stream Start"))
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .peek(e -> System.out.println("Executives"))
                .filter(e -> e.getState().equals("CO"))
                .peek(e -> System.out.println("CO Executives"))
                .findFirst();

        if(result.isPresent()) {
            result.get().print();
        }
    }
}
