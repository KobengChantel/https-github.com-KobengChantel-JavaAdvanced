package Lesson8.ex08_3_exercise;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Oracle
 * Streams and filters
 */
public class RoboMailTest01 {
  
  public static void main(String[] args) {
    
    List<Employee> pl = Employee.createShortList();
    RoboMail01 robo = new RoboMail01();
        
    System.out.println("\n==== RoboMail 01");    
    System.out.println("\n=== All Sales 50+");

    Predicate<Employee> over50 = p -> p.getAge() >= 50 && p.getDept().equals("Sales");
    pl.stream()
            .filter(over50)
            .forEach(p -> robo.roboMail(p));

  }
}
