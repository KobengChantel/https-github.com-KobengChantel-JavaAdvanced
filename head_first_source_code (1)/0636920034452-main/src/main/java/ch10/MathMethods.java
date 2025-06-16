package ch10;

/**
 * The MathMethods class demonstrates usage of various static methods
 * from the Math class in Java such as random, abs, round, min, max, and sqrt.
 */
public class MathMethods {

  /**
   * Generates random numbers using Math.random().
   * Prints a random double between 0.0 and 1.0,
   * and a random integer between 0 and 4.
   */
  static void random() {
    double r1 = Math.random();  // random double >= 0.0 and < 1.0
    System.out.println("r1 = " + r1);
    int r2 = (int) (Math.random() * 5); // cast random double scaled to 0-4 as int
    System.out.println("r2 = " + r2);
  }

  /**
   * Demonstrates Math.abs() method which returns the absolute value.
   * Works for int and double types.
   */
  static void abs() {
    int x = Math.abs(-240);       // returns 240
    double d = Math.abs(240.45);  // returns 240.45
  }

  /**
   * Demonstrates Math.round() which rounds floating-point numbers
   * to the nearest integer (int for float input, long for double input).
   */
  static void round() {
    int x = Math.round(-24.8f);  // returns -25 (rounded)
    System.out.println("x = " + x);
    int y = Math.round(24.45f);  // returns 24 (rounded)
    System.out.println("y = " + y);

    long z = Math.round(24.45);  // returns 24L (rounded)
    System.out.println("z = " + z);
  }

  /**
   * Demonstrates Math.min() which returns the smaller of two numbers.
   */
  static void min() {
    int x = Math.min(24, 240);  // returns 24
    System.out.println("x = " + x);

    double y = Math.min(90876.5, 90876.49);  // returns 90876.49
    System.out.println("y = " + y);
  }

  /**
   * Demonstrates Math.max() which returns the larger of two numbers.
   */
  static void max() {
    int x = Math.max(24, 240);  // returns 240
    System.out.println("x = " + x);
    double y = Math.max(90876.5, 90876.49);  // returns 90876.5
    System.out.println("y = " + y);
  }

  /**
   * Demonstrates Math.sqrt() which calculates the square root.
   */
  static void sqRt() {
    double x = Math.sqrt(9);    // returns 3.0
    System.out.println("x = " + x);
    double y = Math.sqrt(42.0); // returns approximately 6.4807
    System.out.println("y = " + y);
  }

  /**
   * Main method runs the sqRt() method as an example.
   */
  public static void main(String[] args) {
    sqRt();
  }
}
