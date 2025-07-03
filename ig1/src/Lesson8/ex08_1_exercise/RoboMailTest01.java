package Lesson8.ex08_1_exercise;

import java.util.List;
import java.util.function.Predicate;

// This program filters employees based on department, role, and age, then simulates sending emails and texts using streams and predicates.

public class RoboMailTest01 {

  public static void main(String[] args) {

    // Create a list of employees using the factory method
    List<Employee> pl = Employee.createShortList();

    // Create an instance of RoboMail01 to send notifications
    RoboMail01 robo = new RoboMail01();

    // Predicate to filter only executives in the Sales department
    Predicate<Employee> salesExecutives =
            p -> p.getRole().equals(Role.EXECUTIVE)
                    && p.getDept().equals("Sales");

    // Predicate to filter all Sales department employees over the age of 50
    Predicate<Employee> salesEmployeesOver50 =
            p -> p.getAge() >= 50 && p.getDept().equals("Sales");

    System.out.println("\n==== RoboMail 01");

    System.out.println("\n=== Sales Execs ===");
    // Stream to email all Sales Executives
    pl.stream()
            .filter(salesExecutives)
            .forEach(p -> robo.roboMail(p));

    // Stream to text all Sales Executives
    pl.stream()
            .filter(salesExecutives)
            .forEach(p -> robo.roboText(p));

    System.out.println("\n=== All Sales ===");
    // Stream to email all Sales employees over 50
    pl.stream()
            .filter(salesEmployeesOver50)
            .forEach(p -> robo.roboMail(p));

    // Stream to text all Sales employees over 50
    pl.stream()
            .filter(salesEmployeesOver50)
            .forEach(p -> robo.roboText(p));
  }
}
