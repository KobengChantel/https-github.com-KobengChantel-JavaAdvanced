package Lesson17;

import java.time.LocalDate;
import java.util.List;
import static java.time.temporal.ChronoUnit.DAYS;

/**
 * program calculates and displays accrued vacation days for employees based on their roles over a period of time, and also prints bonus summaries for executives
 */

public class VaccationTest {

    public static void main(String[] args) {

        List<Employee> eList = Employee.createShortList();

        // Calc accrued days
        LocalDate yearStart = LocalDate.of(2014,1,1);
        long dayCount = yearStart.until(LocalDate.now(), DAYS);

        // Print Starting values
        System.out.println("\nDays: " + dayCount);
        System.out.printf("Vacation Accrual Exec, Manager, Staff: %2.4f, %2.4f, %2.4f%n",
                VacAccrual.EXECUTIVE.perDay(), VacAccrual.MANAGER.perDay(), VacAccrual.STAFF.perDay());


        // Print Vacation Summary Managers
        System.out.println("\n== Vacation Summary List ==");
        eList.stream()
                .filter(e -> e.getRole().equals(Role.MANAGER))
                .forEach(
                        e -> System.out.printf(
                                " Name: " + e.getGivenName() + " " +
                                        e.getSurName() + " Role: " + e.getRole() + " Dept: " +
                                        e.getDept() + " ST: " + e.getState() +
                                        " Vacation: %,6.4f %n", VacAccrual.byRole(e.getRole()) * dayCount
                        )
                );

        // Print Vacation Summary Staff
        System.out.println("\n== Vacation Summary List ==");
        eList.stream()
                .filter(e -> e.getRole().equals(Role.STAFF))
                .forEach(
                        e -> System.out.printf(
                                " Name: " + e.getGivenName() + " " +
                                        e.getSurName() + " Role: " + e.getRole() + " Dept: " +
                                        e.getDept() + " ST: " + e.getState() +
                                        " Vacation: %,6.4f %n", VacAccrual.byRole(e.getRole()) * dayCount
                        )
                );

        // Print Vacation Summary Staff
        System.out.println("\n== Exec Bonus Summary List ==");
        eList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .forEach(
                        e -> System.out.printf(
                                "Name: " + e.getGivenName() + " " +
                                        e.getSurName() + " Role: " + e.getRole() + " Dept: " +
                                        e.getDept() + " ST: " + e.getState() +
                                        " Bonus: %,6.2f %n", Bonus.byRole(e.getRole()) * e.getSalary())
                );

    }
}
