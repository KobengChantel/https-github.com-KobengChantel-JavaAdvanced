package ch4;

// This class defines two integer fields and a method that returns the sum of these two integers.

class AddThing {
  int a;        // Instance variable 'a', default initialized to 0
  int b = 12;   // Instance variable 'b', explicitly initialized to 12

  public int add() {
    int total = a + b;  // Calculate sum of 'a' and 'b'
    return total;       // Return the result
  }
}
