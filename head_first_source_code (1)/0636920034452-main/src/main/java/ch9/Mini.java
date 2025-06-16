package ch9;

import java.awt.Color;

// Mini class extends Car and adds a color attribute with multiple constructors demonstrating constructor chaining and super calls.

class Mini extends Car {
  private Color color;  // Instance variable to store the color of the Mini car

  // No-argument constructor: calls the constructor with Color.RED by default
  public Mini() {
    this(Color.RED);   // Calls Mini(Color c) constructor
  }

  // Constructor that takes a Color parameter and calls the superclass constructor with the name "Mini"
  public Mini(Color c) {
    super("Mini");     // Calls Car(String size) constructor with "Mini"
    color = c;         // Sets the color attribute
    // more initialization code could go here
  }

  // Constructor that takes an int size parameter
  public Mini(int size) {
    this(Color.RED);   // Calls Mini(Color c) constructor

    // The following line won't compile because a call to super() or this() must be the first statement
    // super(size);    // Uncommenting this causes compilation error
  }
}
