package Lesson9.ex09_1_exercise;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {
  
  public static void main(String[] args) {
    
    List<Employee> eList = Employee.createShortList();
    Employee first = eList.get(0);
    
    Consumer<Employee> eCons = e -> System.out.println(
            "Name: " + e.getSurName() + "\nRole: "
            + e.getRole() + "\nSalary: " + e.getSalary()
    ); // Write your consumer lambda here
    
    System.out.println("=== First Salary");
    eCons.accept(first);
    
  }
}
