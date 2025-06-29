package Lesson9.ex09_2_exercise;

import java.util.List;
import java.util.function.ToDoubleFunction;

public class FunctionTest {
  
  public static void main(String[] args) {
    
    List<Employee> eList = Employee.createShortList();
    Employee first = eList.get(0);
    
    ToDoubleFunction<Employee> eFunc = e -> e.getSalary() * Bonus.byRole(e.getRole()); // Write your function lambda here
      
    System.out.println("=== First Employee Bonus");
    first.printSummary();
    System.out.println("Bonus: " + eFunc.applyAsDouble(first)); // Print the result here
        
  }
}
