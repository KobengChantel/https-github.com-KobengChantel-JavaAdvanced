package ch10;

// Import all static members from java.lang.Math
import static java.lang.Math.*;
// Import the 'out' static member from java.lang.System for easier printing
import static java.lang.System.out;

class WithStatic {
  public static void main(String[] args) {
    // Use the imported static method sqrt() to compute the square root of 2.0
    out.println("sqrt " + sqrt(2.0));

    // Use the imported static method tan() to compute the tangent of 60 radians
    out.println("tan " + tan(60));
  }
}
