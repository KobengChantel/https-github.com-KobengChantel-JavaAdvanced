package ch10;

/**
 * The ConstantInit3 class demonstrates initializing
 * a static final variable using a static initializer block.
 */
public class ConstantInit3 {
  // Declare a public static final double variable VAL
  public static final double VAL;

  // Static initializer block runs once when the class is loaded
  static {
    // Initialize VAL with a random double between 0.0 and 1.0
    VAL = Math.random();
  }
}
