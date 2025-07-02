package Lesson10;

import java.util.List;

public class TestPeek {
    public static void main(String[] args) {
        List<Employee> eList = Employee.createShortList();
        //eList.forEach(e-> e.printSummary());
        System.out.println("===Bonuses===");
        eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .filter(e -> e.getState().equals("CO"))
                //displays information before it is mapped
                .peek(e -> System.out.println("\nName: " + e.getGivenName() + " " + e.getSurName() +
                        "\nSalary: " + e.getSalary() + "\nBonus: " + Bonus.byRole(e.getRole())
                ))
                .map(e -> e.getSalary() * Bonus.byRole(e.getRole()))
                .forEach(s -> System.out.printf("Bonus paid: $%,6.2f %n", s));
    }
}
