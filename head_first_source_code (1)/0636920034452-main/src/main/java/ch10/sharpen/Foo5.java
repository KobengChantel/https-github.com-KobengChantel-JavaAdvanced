package ch10.sharpen;

/**
 * The Foo5 class demonstrates the use of a static final variable
 * and a method with a final parameter that shadows the class variable.
 */
public class Foo5 {
  // Static final variable x is a constant shared by all instances
  static final int x = 12;

  /**
   * The go method takes a final parameter x.
   * This local parameter shadows the static variable x,
   * so when printing x inside the method, it refers to the parameter.
   *
   * @param x the final parameter that cannot be modified inside the method
   */
  public void go(final int x) {
    System.out.println(x);  // Prints the method parameter, not the class variable
  }
}
