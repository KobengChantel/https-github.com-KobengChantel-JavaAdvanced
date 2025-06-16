package ch1;

// This program uses an if-else statement to check if a variable equals 3 and prints different messages based on the result, followed by a message that always prints.

class IfTest2 {
  public static void main(String[] args) {
    int x = 2; // Declare and initialize x with value 2

    if (x == 3) { // Check if x equals 3
      System.out.println("x must be 3"); // This runs if x is 3
    } else {
      System.out.println("x is NOT 3"); // This runs if x is not 3 (which it is not here)
    }

    System.out.println("This runs no matter what"); // Always runs regardless of condition
  }
}
