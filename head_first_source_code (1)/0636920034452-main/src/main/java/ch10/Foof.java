package ch10;

/**
 * The Foof class demonstrates usage of final instance variables,
 * constructor initialization, and final method parameters/local variables.
 */
class Foof {
  // Final instance variable size initialized inline; value cannot be changed later
  final int size = 3;

  // Final instance variable whuffie must be assigned exactly once,
  // so it is initialized in the constructor
  final int whuffie;

  /**
   * Constructor assigns the final variable whuffie.
   * This ensures whuffie is initialized before the object is fully constructed.
   */
  Foof() {
    whuffie = 42;
  }

  /**
   * Method with a final parameter x.
   * The final keyword means x cannot be reassigned within this method.
   *
   * @param x a final parameter that cannot be changed inside the method
   */
  void doStuff(final int x) {
    // x cannot be reassigned here
  }

  /**
   * Method with a final local variable z.
   * Once assigned, z cannot be modified.
   */
  void doMore() {
    final int z = 7;
    // z cannot be changed after this assignment
  }
}
