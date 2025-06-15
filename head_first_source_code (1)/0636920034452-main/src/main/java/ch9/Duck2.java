package ch9;

// The Duck2 class models a duck with a size attribute and provides constructors to set default or custom sizes.

public class Duck2 {
  int size;  // Instance variable to store the size of the duck

  // No-argument constructor that supplies a default size of 27
  public Duck2() {
    size = 27;  // Default size assigned
  }

  // Constructor that uses the provided duckSize parameter to set the size
  public Duck2(int duckSize) {
    size = duckSize;  // Size set to the value passed in the constructor
  }
}
