package ch9;

/**
 * The StackExample class demonstrates method calls and local variable usage.
 * It simulates how methods interact and how the call stack works during execution.
 */
public class StackExample {

  /**
   * The doStuff method initializes a boolean variable and calls the go method.
   */
  public void doStuff() {
    // Declare and initialize a boolean variable b to true
    boolean b = true;

    // Call the go method with an argument of 4
    go(4);
  }

  /**
   * The go method takes an integer parameter, performs a calculation,
   * calls the crazy method, and may contain additional code.
   *
   * @param x an integer input
   */
  public void go(int x) {
    // Declare an integer variable z and initialize it with x plus 24
    int z = x + 24;

    // Call the crazy method
    crazy();

    // imagine more code here that might use z or perform other operations
  }

  /**
   * The crazy method declares a character variable.
   */
  public void crazy() {
    // Declare a char variable c and initialize it with 'a'
    char c = 'a';
  }
}
