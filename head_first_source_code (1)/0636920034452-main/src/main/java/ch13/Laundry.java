package ch13;

// Represents a Laundry service that can perform laundry operations which may throw a ClothingException.

public class Laundry {
  // Method that performs laundry and may throw a ClothingException if something goes wrong
  public void doLaundry() throws ClothingException {
    // code that could throw either exception (TeeShirtException, LingerieException, or general ClothingException)
  }
}
