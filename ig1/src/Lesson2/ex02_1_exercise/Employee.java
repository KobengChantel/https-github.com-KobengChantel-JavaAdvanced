package Lesson2.ex02_1_exercise;

// This program defines an Employee class, creates an instance, assigns values to its fields, and prints
// the employee's details.

public class Employee {
    // Fields to store the employee's name, surname, and age
    public String name, surname;
    public int age;

    public static void main(String[] args) {
        // Create a new Employee object
        Employee emp1 = new Employee();

        // Assign values to the object's fields
        emp1.name = "Jada";
        emp1.surname = "Mathele";
        emp1.age = 19;

        // Print the employee's full name
        System.out.println("Employee Name:\n" + emp1.name + " " + emp1.surname);

        // Print a blank line
        System.out.println();

        // Print the employee's age
        System.out.println("Employee Age:\n" + emp1.age);
    }
}
