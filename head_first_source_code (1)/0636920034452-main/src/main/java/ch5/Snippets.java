package ch5;

// This code demonstrates two methods showing how to use for and while loops to print numbers from 0 to 7 and then print "done".

public class Snippets {
  void forLoop() {
    for (int i = 0; i < 8; i++) {      // Loop from 0 to 7 using for loop
      System.out.println(i);
    }
    System.out.println("done");         // Print "done" after loop ends
  }

  void whileLoop() {
    int i = 0;
    while (i < 8) {                    // Loop from 0 to 7 using while loop
      System.out.println(i);
      i++;
    }
    System.out.println("done");         // Print "done" after loop ends
  }
}
