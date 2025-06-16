package ch10;

/**
 * The NoStatic class demonstrates calling static methods from the Math class
 * directly without needing to create an instance of Math.
 */
class NoStatic {
  public static void main(String[] args) {
    // Calculate and print the square root of 2.0
    System.out.println("sqrt " + Math.sqrt(2.0));

    // Calculate and print the tangent of 60 radians
    // Note: Math.tan expects radians, not degrees
    System.out.println("tan " + Math.tan(60));
  }
}
