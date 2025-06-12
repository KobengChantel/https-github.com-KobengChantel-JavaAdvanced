package ch7;

// This class defines a Boat with a length property, methods to set and get the length, and a move behavior that prints "drift".

public class Boat {
  private int length; // Length of the boat

  public void setLength(int len) {
    length = len; // Set the length of the boat
  }

  public int getLength() {
    return length; // Return the current length of the boat
  }

  public void move() {
    System.out.print("drift  "); // Simulate the boat's movement
  }
}
