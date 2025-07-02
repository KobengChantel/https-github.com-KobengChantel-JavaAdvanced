package Lesson4;

// This program creates an Employee object and prints it, relying on the Employee class's overridden toString method.

public class toStringTest {
    public static void main(String[] args) {
        // Create an Employee object with id, name, ssn, and salary
        Employee e = new Employee(400, "Betty", "20202-785933", 6000);

        // Print the Employee object, which calls the overridden toString() method
        System.out.println(e);
    }
}
