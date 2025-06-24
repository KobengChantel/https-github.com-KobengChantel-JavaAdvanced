package Lesson4;

// This program tests object equality using the overridden equals method in the Employee class.

public class EqualityTest {
    public static void main(String[] args) {
        // Create two different Employee objects with identical data
        Employee emp1 = new Employee(400, "Betty", "20202-785933", 6000);
        Employee emp2 = new Employee(400, "Betty", "20202-785933", 6000);

        // Compares objects using overridden equals method – checks field values, not references
        System.out.println(emp1.equals(emp2)); // true if equals is overridden properly

        // Now both variables point to the same object (same reference)
        emp1 = emp2;

        // Will return true because they refer to the same object in memory
        System.out.println(emp1.equals(emp2)); // true
    }
}
