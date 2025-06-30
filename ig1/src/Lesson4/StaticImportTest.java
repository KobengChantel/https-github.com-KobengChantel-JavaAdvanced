package Lesson4;

import static java.lang.Math.*;  // Import all static members of the Math class for direct usage without Math prefix

// This program demonstrates the use of static import to call Math class methods directly without prefixing with 'Math.'
public class StaticImportTest {
    public static void main(String[] args) {
        // Generate a random double between 0.0 and 1.0, multiply by 200 and print the result
        System.out.println("Random: " + random() * 200);

        // Calculate and print the square root of 25.0
        System.out.println("Square Root: " + sqrt(25.0));

        // Generate a random double, multiply by 200, round it to the nearest long and print it
        System.out.println("Rounded random: " + round(random() * 200));

        // Print the absolute value of -22
        System.out.println("Absolute: " + abs(-22));
    }
}
