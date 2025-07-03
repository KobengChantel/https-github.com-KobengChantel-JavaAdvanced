package Lesson8.ex08_3_exercise;

import java.util.List;
import java.util.function.Predicate;

// This program uses Java streams and predicates to filter Sales employees aged 50 and above, then sends them simulated emails.

public class RoboMailTest01 {

  public static void main(String[] args) {

    // Create a list of sample employees
    List<Employee> pl = Employee.createShortList();

    // Create an instance of RoboMail01 to simulate communication
    RoboMail01 robo = new RoboMail01();

    System.out.println("\n==== RoboMail 01");
    System.out.println("\n=== All Sales 50+");

    // Define a predicate to filter Sales department employees who are aged 50 or older
    Predicate<Employee> over50 =
            p -> p.getAge() >= 50 && p.getDept().equals("Sales");

    // Use a stream to filter and send emails to qualified employees
    pl.stream()
            .filter(over50)
            .forEach(p -> robo.roboMail(p));
  }
}
