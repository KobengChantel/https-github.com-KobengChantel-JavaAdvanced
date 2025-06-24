package Lesson5.ex05_2_exercise;

// This class contains the main method to create Employee objects and demonstrate calculating their withholding and bonus.

public class Main {
    public static void main(String[] args) {
        // Create an Employee object for Jane with specified details
        Employee jane = new Employee("Jane Doe", "Manager", "HR", 65000);
        // Create an Employee object for John with specified details
        Employee john = new Employee("John Doe", "Staff", "HR", 55000);

        // Print Jane's withholding amount calculated from her salary
        System.out.println("Jane's withholding: " + jane.getWithholding());
        // Print John's bonus amount calculated from his salary
        System.out.println("John's bonus: " + john.getBonus());
    }
}
