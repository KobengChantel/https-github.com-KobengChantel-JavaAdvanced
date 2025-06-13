package ch9;

// This class demonstrates a simple example of dereferencing an object reference.

public class DeRef {
  // Create a new Duck object and assign its reference to variable d
  Duck d = new Duck();

  // Method that sets the Duck reference to null, effectively dereferencing the Duck object
  public void go() {
    d = null; // The original Duck object is no longer referenced by d
  }
}
