package Lesson4;

// This program demonstrates the use of some common Math class methods in Java.

public class MathTest {
    public static void main(String[] args) {
        // Prints a random double between 0.0 (inclusive) and 200.0 (exclusive)
        System.out.println("Random: " + Math.random() * 200);

        // Prints the square root of 25.0
        System.out.println("Square Root: " + Math.sqrt(25.0));

        // Prints a random number between 0 and 200 rounded to the nearest long integer
        System.out.println("Rounded random: " + Math.round(Math.random() * 200));

        // Prints the absolute value of -22
        System.out.println("Absolute: " + Math.abs(-22));
    }
}
