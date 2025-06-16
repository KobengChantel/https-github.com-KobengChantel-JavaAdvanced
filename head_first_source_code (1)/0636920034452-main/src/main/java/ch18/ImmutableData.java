package ch18;

// This class defines an immutable data structure with final fields and no setters, ensuring thread safety through immutability.

public class ImmutableData {
  final String name;  // The name value, cannot be changed after object creation
  final int value;    // The integer value, also immutable once set

  // Constructor that initializes all final fields
  public ImmutableData(String name, int value) {
    this.name = name;
    this.value = value;
  }

  // Getter for name
  public String getName() { return name; }

  // Getter for value
  public int getValue() { return value; }
}
