package ch1;

// This code demonstrates a countdown using a while loop that prints "small x" when x becomes less than 3.

public class Exercise1b {
  public static void main(String[] args) {
    int x = 5;  // Initialize x to 5

    while (x > 1) {        // Loop continues as long as x is greater than 1
      x = x - 1;           // Decrement x by 1 in each iteration

      if (x < 3) {         // If x is less than 3
        System.out.println("small x");  // Print "small x"
      }
    }
  }
}
