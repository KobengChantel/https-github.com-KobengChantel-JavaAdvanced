package Lesson8.ex08_1_exercise;

import java.util.List;
import java.util.function.Predicate;

public class RoboMailTest01 {
  
  public static void main(String[] args) {
    
    List<Employee> pl = Employee.createShortList();
    RoboMail01 robo = new RoboMail01();

    Predicate<Employee> salesExecutives = 
      p -> p.getRole().equals(Role.EXECUTIVE) 
        && p.getDept().equals("Sales");
    
    Predicate<Employee> salesEmployeesOver50 = 
      p -> p.getAge() >= 50 && p.getDept().equals("Sales");
    
    System.out.println("\n==== RoboMail 01");
    System.out.println("\n=== Sales Execs ===");
    //mail stream
    pl.stream()
            .filter(salesExecutives)
            .forEach(p -> robo.roboMail(p));
    //text stream
    pl.stream()
            .filter(salesExecutives)
            .forEach(p -> robo.roboText(p));
    
    System.out.println("\n=== All Sales ===");
    //mail stream
    pl.stream()
            .filter(salesEmployeesOver50)
            .forEach(p -> robo.roboMail(p));
    //text stream
    pl.stream()
            .filter(salesEmployeesOver50)
            .forEach(p -> robo.roboText(p));
  }
}
