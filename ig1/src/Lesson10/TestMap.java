package Lesson10;

import java.util.List;

public class TestMap {
    public static void main(String[] args) {
        List<Employee> eList = Employee.createShortList();
        //eList.forEach(e-> e.printSummary());
        System.out.println("Bonuses");
        eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .filter(e -> e.getState().equals("CO"))
                .map(e -> e.getSalary() * Bonus.byRole(e.getRole()))
                .forEach(s -> System.out.printf("Bonus paid: $%,6.2f %n", s));
    }
}
