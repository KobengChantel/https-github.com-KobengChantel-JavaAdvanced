package ch10.sharpen;

/**
 * The Foo class demonstrates the use of a static variable shared across all instances.
 */
public class Foo {
  // Static integer variable shared by all Foo objects
  static int x;

  /**
   * The go method prints the current value of the static variable x.
   */
  public void go() {
    System.out.println(x);
  }
}
