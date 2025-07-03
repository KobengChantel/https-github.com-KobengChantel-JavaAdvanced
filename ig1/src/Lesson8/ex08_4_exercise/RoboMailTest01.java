package Lesson8.ex08_4_exercise;

import java.util.List;
import java.util.function.Predicate;

/**
 * RoboMailTest01 tests RoboMail01 by filtering a list of employees
 * and simulating sending emails to males in the Engineering department under 65.
 */
public class RoboMailTest01 {

  public static void main(String[] args) {

    // Create a sample list of employees
    List<Employee> pl = Employee.createShortList();
    RoboMail01 robo = new RoboMail01();

    System.out.println("\n==== RoboMail 01");
    System.out.println("\n=== Male Eng Under 65");

    // Predicate to filter male employees in "Eng" department younger than 65
    Predicate<Employee> under65Eng = p -> p.getGender().equals(Gender.MALE) && p.getDept().equals("Eng") && p.getAge() < 65;

    // Stream the employee list, filter by the predicate, and send robo emails
    pl.stream()
            .filter(under65Eng)
            .forEach(p -> robo.roboMail(p));

  }
}
