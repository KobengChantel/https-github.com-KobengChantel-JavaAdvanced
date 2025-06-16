package ch5;

// This code uses nested for loops to print pairs of i and j values, skipping an extra i value when i equals 1 to demonstrate loop control flow.

class MultiFor {

  public static void main(String[] args) {
    for (int i = 0; i < 4; i++) {

      for (int j = 4; j > 2; j--) {
        System.out.println(i + " " + j);
      }

      if (i == 1) {
        i++;  // Skip the next value of i by incrementing again when i is 1
      }
    }
  }
}
