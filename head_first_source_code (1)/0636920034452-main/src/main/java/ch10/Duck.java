package ch10;

/**
 * The Duck class models a duck with an instance size and
 * keeps track of the total number of Duck instances created using a static variable.
 */
public class Duck {
  // Instance variable size: each Duck object has its own size
  private int size;

  // Static variable duckCount: shared among all Duck objects
  // Tracks the total number of Duck instances created
  private static int duckCount = 0;

  /**
   * Constructor for Duck.
   * Increments the static duckCount each time a new Duck is instantiated.
   */
  public Duck() {
    duckCount++;
  }

  /**
   * Sets the size of the duck.
   * @param s the new size of this Duck instance
   */
  public void setSize(int s) {
    size = s;
  }

  /**
   * Gets the size of the duck.
   * @return the size of this Duck instance
   */
  public int getSize() {
    return size;
  }
}
