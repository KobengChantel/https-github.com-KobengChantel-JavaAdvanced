package ch10.sharpen;

/**
 * The Foo3 class shows a commented-out final instance variable
 * and a method that tries to use it.
 */
public class Foo3 {
  // The final keyword means this variable must be assigned exactly once.
  // But it's commented out here, so 'x' is not declared.
  // final int x;

  /**
   * The go method tries to print 'x',
   * but since 'x' is not declared (commented out), this causes a compile error.
   */
  public void go() {
    // This line is commented out because 'x' does not exist.
    // System.out.println(x);
  }
}
