package ch10.sharpen;

/**
 * The Foo6 class demonstrates having an instance variable
 * and a static method that uses a parameter with the same name.
 */
public class Foo6 {
  // Instance variable x belongs to each Foo6 object
  int x = 12;

  /**
   * Static method go accepts a final parameter x and prints it.
   * This method cannot access the instance variable x directly
   * because it is static and does not have access to instance data.
   *
   * @param x the final integer parameter to print
   */
  public static void go(final int x) {
    System.out.println(x);  // Prints the parameter x passed into the method
  }
}
