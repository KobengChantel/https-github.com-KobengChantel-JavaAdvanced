package Lesson8.ex08_2_exercise;

import java.util.List;
import java.util.function.Predicate;

public class RoboMailTest01 {
  
  public static void main(String[] args) {
    
    List<Employee> pl = Employee.createShortList();
    RoboMail01 robo = new RoboMail01();    

    Predicate<Employee> mailSales = p -> p.getAge() >= 60 && p.getDept().equals("Sales");
    System.out.println("\n==== RoboMail 01");
    System.out.println("\n=== Sales Execs");
    
    pl.stream()
            .filter(mailSales)
            .forEach(p -> robo.roboMail(p));
  }
}
