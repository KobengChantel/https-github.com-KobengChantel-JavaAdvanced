package ch16;

// This class defines a serializable Dog object with a unique serialVersionUID for version control during serialization.

public class Dog {

  // Unique ID used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible.
  static final long serialVersionUID = -6849794470754667710L;

  private String name; // Dog's name (will be serialized)
  private int size;    // Dog's size (will be serialized)

  // method code here (e.g., constructors, getters, setters)
}
