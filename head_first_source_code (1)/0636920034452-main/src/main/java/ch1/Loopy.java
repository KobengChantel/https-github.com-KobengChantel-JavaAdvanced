package ch1;

// This program demonstrates a basic while loop that prints messages and the value of x from 1 to 3, showing the flow before, during, and after the loop.

public class Loopy {
  public static void main(String[] args) {
    int x = 1; // Initialize x to 1
    System.out.println("Before the Loop"); // Print message before entering the loop

    while (x < 4) { // Loop runs while x is less than 4
      System.out.println("In the loop"); // Print message during the loop
      System.out.println("Value of x is " + x); // Print current value of x
      x = x + 1; // Increment x by 1
    }

    System.out.println("This is after the loop"); // Print message after the loop ends
  }
}
