package ch5;

// This code runs nested loops to manipulate variables x and y, and demonstrates how different increments to x affect loop control and the final output.

class MixFor5 {
  public static void main(String[] args) {
    int x = 0;
    int y = 30;
    for (int outer = 0; outer < 3; outer++) {
      for (int inner = 4; inner > 1; inner--) {
        // candidate code goes here

        // end candidate code

        y = y - 2;
        if (x == 6) {
          break;
        }
        x = x + 3;
      }
      y = y - 2;
    }
    System.out.println(x + " " + y);
  }
}

// candidates for the inner loop modification:
// x = x + 3;
// x = x + 6;
// x = x + 2;
// x++;
// x--;
// x = x + 0;
