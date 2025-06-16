package ch1;

// This class demonstrates basic Java programming constructs including variable assignments, loops, conditional statements, and boolean tests with example methods showing usage of each.

public class Snippets {
  void statements() {
    int x = 3;                        // Declare an integer x and assign 3
    String name = "Dirk";             // Declare a String variable name with value "Dirk"
    x = x * 17;                      // Multiply x by 17 and reassign
    System.out.print("x is " + x);   // Print the value of x
    double d = Math.random();        // Generate a random double between 0 and 1
    // this is a comment
  }

  void looping(int x) {
    while (x > 12) {                 // While x is greater than 12
      x = x - 1;                    // decrement x by 1
    }

    for (int i = 0; i < 10; i = i + 1) {  // Loop i from 0 to 9
      System.out.print("i is now " + i);  // Print current value of i
    }
  }

  void conditions(int x, String name) {
    if (x == 10) {                  // If x equals 10
      System.out.print("x must be 10");  // Print this message
    } else {
      System.out.print("x isn't 10");    // Otherwise print this message
    }
    if ((x < 3) & (name.equals("Dirk"))) { // If x less than 3 AND name is "Dirk"
      System.out.println("Gently");        // Print "Gently"
    }
    System.out.print("this line runs no matter what"); // Always runs regardless of conditions
  }

  void booleanTests() {
    int x = 4; // assign 4 to x
    while (x > 3) {             // Loop runs as long as x is greater than 3
      x = x - 1;               // Decrement x to avoid infinite loop
    }
    int z = 27;                // assign 27 to z
    while (z == 17) {          // Loop will not run because z is not 17
      // no code here
    }
  }
}
