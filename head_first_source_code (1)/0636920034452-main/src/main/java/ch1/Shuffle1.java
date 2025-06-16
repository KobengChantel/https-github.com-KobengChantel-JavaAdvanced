package ch1;

// This program prints a specific character pattern using a while loop with conditions that alter the loop counter and print accordingly.

class Shuffle1 {
  public static void main(String[] args) {

    int x = 3;                      // Initialize x to 3

    while (x > 0) {                 // Loop runs while x is greater than 0

      if (x > 2) {
        System.out.print("a");      // Print 'a' only when x is initially 3 (first iteration)
      }

      x = x - 1;                    // Decrement x by 1

      System.out.print("-");        // Print a dash after decrementing x

      if (x == 2) {
        System.out.print("b c");    // When x is 2, print "b c"
      }

      if (x == 1) {
        System.out.print("d");      // When x is 1, print 'd'
        x = x - 1;                  // Further decrement x to skip next iteration
      }
    }
  }
}
