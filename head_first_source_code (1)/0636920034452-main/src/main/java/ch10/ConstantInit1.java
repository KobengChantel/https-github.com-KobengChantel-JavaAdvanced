package ch10;

/**
 * The ConstantInit1 class demonstrates how to initialize
 * a static final constant using a static initializer block.
 */
class ConstantInit1 {
  // Declare a static final variable X, which must be initialized once
  final static int X;

  // Static initializer block to initialize the static final variable X
  static {
    X = 42;  // Assign value to X exactly once during class loading
  }
}
