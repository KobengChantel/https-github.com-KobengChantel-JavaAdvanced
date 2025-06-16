package ch1;

// This program demonstrates a simple `if` statement that checks if a variable equals 3 and prints a message if true, followed by a message that always prints.

class IfTest {
  public static void main (String[] args) {
    int x = 3; // Declare and initialize x with value 3

    if (x == 3) { // Check if x is equal to 3
      System.out.println("x must be 3"); // This line prints if the condition is true
    }

    System.out.println("This runs no matter what"); // This line always prints regardless of the condition
  }
}
