package Lesson4;

// This program tests the Statistics.avg method by passing multiple integers and no integers, demonstrating varargs behavior.

public class Testvarargs {
    public static void main(String[] args) {
        // Calculate average of given numbers using varargs
        float total = Statistics.avg(4, 200, 68, 7);

        // Calculate average with no arguments, should return 0 without error
        float total2 = Statistics.avg();

        // Print the average of the first set of numbers
        System.out.println(total);

        // Print the average when no numbers are passed (0)
        System.out.println(total2);
    }
}
