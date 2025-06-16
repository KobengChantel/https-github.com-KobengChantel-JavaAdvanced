package ch10.sharpen;

/**
 * The Foo2 class demonstrates the difference between
 * instance variables and static methods.
 */
public class Foo2 {
  // Instance variable x, each Foo2 object has its own copy
  int x;

  /**
   * Static method go attempts to print x,
   * but this is commented out because a static method
   * cannot access instance variables directly.
   */
  public static void go() {
    // This line is illegal because 'x' is an instance variable,
    // and static methods do not have access to instance fields.
    // System.out.println(x);
  }
}
