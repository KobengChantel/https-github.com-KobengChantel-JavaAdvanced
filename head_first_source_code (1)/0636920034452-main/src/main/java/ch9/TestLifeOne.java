package ch9;

/**
 * The TestLifeOne class demonstrates variable scope and lifetime.
 */
public class TestLifeOne {

  /**
   * The read method declares a local variable s and calls the sleep method.
   */
  public void read() {
    // Local variable s is declared and initialized to 42
    int s = 42;

    // Call the sleep method
    sleep();
  }

  /**
   * The sleep method attempts to modify variable s, but
   * s is not visible here because it was declared in the read() method.
   */
  public void sleep() {
    // The following line is commented out because it would cause a compilation error:
    // "cannot find symbol" since 's' is local to read() and not accessible here.
    // s = 7;
  }
}
