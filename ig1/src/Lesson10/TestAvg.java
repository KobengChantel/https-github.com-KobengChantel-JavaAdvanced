package Lesson10;

import java.util.List;
import java.util.OptionalDouble;

public class TestAvg {
    public static void main(String[] args) {
        List<Employee> eList = Employee.createShortList();
        OptionalDouble result;

        System.out.println("\n== Average CO Bonus Details ==");

        result = eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .filter(e -> e.getState().equals("CO"))
                .peek(e -> System.out.print("Name: " + e.getGivenName()
                        + " " + e.getSurName() + " "))
                .mapToDouble(e -> e.getSalary() * Bonus.byRole(e.getRole()))
                .peek(d -> System.out.printf("Bonus paid: $%,6.2f %n", d))
                .average();

        if (result.isPresent()){
            System.out.printf("Average Bonuses paid: $%,6.2f %n",
                    result.getAsDouble());
        }
    }
}
