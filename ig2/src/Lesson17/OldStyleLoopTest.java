package Lesson17;

import java.util.List;

/**
 * Demonstrates the traditional way of looping through a list of employees using a for-each loop.
 * Filters employees who are executives located in Colorado (state = "CO") and sums their salaries.
 */
public class OldStyleLoopTest {
    public static void main(String[] args) {

        // Get a list of sample employees
        List<Employee> eList = Employee.createShortList();

        // Initialize a variable to keep track of the total salary
        double sum = 0;

        // Loop through each employee in the list
        for(Employee e : eList){
            // Use an if statement to filter employees
            // Only include those in state "CO" and with role EXECUTIVE
            if(e.getState().equals("CO") && e.getRole().equals(Role.EXECUTIVE)){
                // Print a summary of the employee that meets the condition
                e.printSummary();
                // Add this employee's salary to the total sum
                sum += e.getSalary();
            }
        }
        // Print the total salary of Colorado executives formatted with commas and two decimals
        System.out.printf("Total CO Executive Pay: $%,9.2f %n", sum);
    }
}
