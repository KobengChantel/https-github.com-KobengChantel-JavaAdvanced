package Lesson8.ex08_2_exercise;

import java.util.List;
import java.util.function.Predicate;

// This program filters employees in the Sales department aged 60 or older and simulates sending them emails using streams and predicates.

public class RoboMailTest01 {

  public static void main(String[] args) {

    // Create a sample list of employees
    List<Employee> pl = Employee.createShortList();

    // Create an instance of RoboMail01 to send messages
    RoboMail01 robo = new RoboMail01();

    // Predicate to select employees who are 60 or older and work in the Sales department
    Predicate<Employee> mailSales =
            p -> p.getAge() >= 60 && p.getDept().equals("Sales");

    System.out.println("\n==== RoboMail 01");
    System.out.println("\n=== Sales Execs");

    // Filter the employee list using the predicate and send emails
    pl.stream()
            .filter(mailSales)
            .forEach(p -> robo.roboMail(p));
  }
}
