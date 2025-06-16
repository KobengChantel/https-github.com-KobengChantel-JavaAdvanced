package ch9;

/**
 * The ReRef class demonstrates reassigning object references.
 * It contains a Duck object reference and shows how to reassign it.
 */
public class ReRef {

  // Create and initialize a Duck object and assign its reference to variable d
  Duck d = new Duck();

  /**
   * Method to reassign the Duck reference d to a new Duck object.
   * This effectively "re-references" d to a different Duck instance.
   */
  public void go() {
    d = new Duck();
  }
}
