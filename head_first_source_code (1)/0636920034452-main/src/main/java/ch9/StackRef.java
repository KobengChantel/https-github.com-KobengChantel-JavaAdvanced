package ch9;

/**
 * The StackRef class demonstrates method calls and creating an object on the stack.
 */
public class StackRef {

  /**
   * The foof method calls the barf method.
   */
  public void foof() {
    // Call barf method
    barf();
  }

  /**
   * The barf method creates a new Duck object with size 24.
   */
  public void barf() {
    // Create a new Duck object with size 24 and assign its reference to local variable d
    Duck d = new Duck(24);
  }
}
