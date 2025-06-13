package ch1;

// This code prints "DooBeeDooBeeDo" by looping "DooBee" twice and then printing "Do".

public class DooBee {
  public static void main(String[] args) {
    int x = 1;  // Initialize a counter variable

    while (x < 3) {             // Loop while x is less than 3
      System.out.print("Doo");  // Print "Doo" without a newline
      System.out.print("Bee");  // Print "Bee" without a newline
      x = x + 1;                // Increment x by 1
    }

    if (x == 3) {               // If x equals 3 after the loop
      System.out.print("Do");   // Print "Do" to complete the song
    }
  }
}
