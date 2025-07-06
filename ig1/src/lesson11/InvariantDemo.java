package lesson11;

import java.util.Scanner;

// This program prompts the user to enter a number between 0 and 20 and uses an assertion to validate the input.

public class InvariantDemo {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number between 0 and 20: ");
        int value = scanner.nextInt();

        // Assert that the entered value is within the valid range; throws AssertionError if not
        assert (value >= 0 && value <= 20) : "Invalid number: " + value;

        System.out.printf("You have entered %d\n", value);
    }
}
