package ch10.sharpen;

/**
 * The Foo4 class demonstrates a static final constant
 * and printing its value in an instance method.
 */
public class Foo4 {
  // Static final variable x is a constant shared by all instances,
  // and its value cannot be changed after initialization.
  static final int x = 12;

  /**
   * The go method prints the value of the static final variable x.
   */
  public void go() {
    System.out.println(x);
  }
}
