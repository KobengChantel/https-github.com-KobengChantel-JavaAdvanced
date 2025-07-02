package Lesson5;

// This class tests the overridden toString method of the Employee class by printing an Employee object.

public class toStringTest {
    public static void main(String[] args) {
        Employee e = new Employee(400, "Betty", "20202-785933", 6000); // Create an Employee instance
        System.out.println(e); // Prints the Employee object, which calls the overridden toString method
    }
}
