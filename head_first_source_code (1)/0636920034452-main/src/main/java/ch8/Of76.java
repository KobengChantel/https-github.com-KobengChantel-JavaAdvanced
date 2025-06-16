package ch8;

// This program demonstrates polymorphism through interface implementation and class inheritance using the Nose interface and Picasso hierarchy.

public class Of76 extends Clowns {
  public static void main(String[] args) {
    // Create an array of Nose type references
    Nose[] i = new Nose[3];

    // Assign different implementations of Nose to the array
    i[0] = new Acts();     // Acts overrides iMethod() to return 5
    i[1] = new Clowns();   // Clowns inherits iMethod() from Picasso, returns 7
    i[2] = new Of76();     // Of76 inherits from Clowns, also returns 7

    // Loop through the array and call iMethod() on each object, printing the result and the class
    for (int x = 0; x < 3; x++) {
      System.out.println(i[x].iMethod()
              + " " + i[x].getClass()); // Shows return value of iMethod and actual class type
    }
  }
}

// Nose interface defines a method to be implemented by classes
interface Nose {
  public int iMethod();
}

// Abstract class Picasso implements Nose and provides a default implementation of iMethod()
abstract class Picasso implements Nose {
  public int iMethod() {
    return 7; // Default behavior returns 7
  }
}

// Clowns extends Picasso and inherits its iMethod() implementation
class Clowns extends Picasso {
  // No override, inherits iMethod() from Picasso
}

// Acts extends Picasso and overrides iMethod() to return a different value
class Acts extends Picasso {
  public int iMethod() {
    return 5; // Acts-specific behavior returns 5
  }
}
