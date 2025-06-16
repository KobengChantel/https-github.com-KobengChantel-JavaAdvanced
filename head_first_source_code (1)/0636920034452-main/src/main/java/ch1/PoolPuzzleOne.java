package ch1;

// This program uses a while loop and multiple conditionals to print a playful sequence of text fragments that change based on the loop counter's value, resulting in a quirky pattern.

class PoolPuzzleOne {
  public static void main(String[] args) {
    int x = 0;

    while (x < 4) {
      System.out.print("a");                 // Print "a" every iteration

      if (x < 1) {                          // On first iteration only
        System.out.print(" ");              // Print a space
      }

      System.out.print("n");                 // Print "n" every iteration

      if (x > 1) {                          // Starting from third iteration
        System.out.print(" oyster");        // Print " oyster"
        x = x + 2;                         // Skip next two iterations by increasing x by 2
      }

      if (x == 1) {                        // On second iteration
        System.out.print("noys");          // Print "noys"
      }

      if (x < 1) {                        // On first iteration
        System.out.print("oise");          // Print "oise"
      }

      System.out.println();                 // Move to next line

      x = x + 1;                          // Increment x by 1 each iteration
    }
  }
}
