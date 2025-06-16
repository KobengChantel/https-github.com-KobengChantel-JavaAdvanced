package ch7;

// This class Sailboat extends Boat and overrides the move method to simulate sailing by printing a message.

public class Sailboat extends Boat {
  public void move() {
    System.out.print("hoist sail ");  // Prints a message indicating the sailboat is moving by hoisting sails
  }
}
