package ch1;

// This code counts down from 5 and prints "small x" when the value of x becomes less than 3.

class Exercise1c {
  public static void main(String[] args) {
    int x = 5;  // Initialize variable x to 5

    while (x > 1) {        // Loop runs while x is greater than 1
      x = x - 1;           // Decrease x by 1 in each iteration

      if (x < 3) {         // Check if x is less than 3
        System.out.println("small x");  // Print message if condition is true
      }
    }
  }
}
