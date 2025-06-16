package ch5;

// This code demonstrates a for loop that increments a value, conditionally prints it after a certain iteration, and breaks the loop when the value exceeds 14.

class Output {
  public static void main(String[] args) {
    Output output = new Output();
    output.go();
  }

  void go() {
    int value = 7;
    for (int i = 1; i < 8; i++) {
      value++;                       // Increment value each loop iteration
      if (i > 4) {                  // After the 4th iteration, pre-increment value and print it
        System.out.print(++value + " ");
      }
      if (value > 14) {             // Break loop if value exceeds 14 and print current i
        System.out.println(" i = " + i);
        break;
      }
    }
  }
}
