package ch1;

// This code demonstrates an infinite loop because `x` is never incremented, and once x > 3, it continuously prints "big x".

class Exercise1a {
  public static void main(String[] args) {
    int x = 1;  // Initialize x to 1

    while (x < 10) {             // Loop while x is less than 10
      if (x > 3) {               // Check if x is greater than 3
        System.out.println("big x");  // Print "big x" if the condition is true
      }
      // Missing increment: x is never updated, so the loop becomes infinite once x > 3
    }
  }
}
