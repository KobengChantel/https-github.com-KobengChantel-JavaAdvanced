package ch12;

import java.util.Optional;

// This program demonstrates the use of Java's Optional class to safely handle the presence or absence of an IceCream object.

public class OptionalExamples {
  public static void main(String[] args) {
    // Attempt to retrieve an Optional-wrapped IceCream object
    Optional<IceCream> optional = getIceCream("Strawberry");

    // Unsafe: calling .get() without checking if the value is present
    IceCream ice = optional.get();  // This will throw NoSuchElementException since the optional is empty

    // Safe check for presence before using the object
    if (optional.isPresent()) {
      ice.eat();  // Call eat() if ice cream is available
    } else {
      System.out.println("No ice cream for you!");  // Message if no ice cream is returned
    }
  }

  // Simulates getting ice cream; always returns an empty Optional (null inside)
  private static Optional<IceCream> getIceCream(String strawberry) {
    return Optional.ofNullable(null);  // Returns Optional.empty
  }

  // Inner class representing IceCream
  private static class IceCream {
    void eat() {
      // Ice cream is eaten (but nothing is printed here)
    }
  }
}
