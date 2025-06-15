package ch9;

// The Duck class models a duck with a size attribute and provides two constructors.

public class Duck {
  int size;  // Instance variable to store the size of the duck

  // No-argument constructor (default)
  public Duck() {
    // No initialization performed here
  }

  // Constructor that initializes the duck size and prints messages
  public Duck(int duckSize) {
    System.out.println("Quack");          // Prints "Quack" when this constructor is called

    size = duckSize;                      // Set the size to the provided duckSize value

    System.out.println("size is " + size); // Prints the size of the duck
  }
}

// Commented-out code shows a bad approach to providing a default size value:
// The constructor checks if the input is zero and sets a default size of 27,
// which is not an ideal design because it mixes defaulting logic with input validation.
/*
public Duck(int newSize) {
  if (newSize == 0) {
    size = 27;  // Default size
  } else {
    size = newSize;
  }
}
*/
