package lesson11;

// This class demonstrates using an if-else structure with assertions to check whether a number is positive, zero, or negative.

public class Invariant {

    // Method to check the sign of a given number and print a message or assert if negative
    static void checkNum(int num) {
        int x = num;

        if (x > 0) {
            System.out.print("number is positive" + x);

        } else if (x == 0) {
            System.out.print("number is zero" + x);
        } else {
            // Assert that x is negative; will throw an AssertionError if assertions are enabled and x is not negative
            assert (x < 0);
        }
    }

    public static void main(String args[]) {
        // Call checkNum with -4, triggering the assertion (assuming assertions are enabled)
        checkNum(-4);
    }
}
