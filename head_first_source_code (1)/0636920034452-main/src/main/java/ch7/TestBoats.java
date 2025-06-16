package ch7;

// This program demonstrates polymorphism by creating different types of boats and calling their move methods.

public class TestBoats {
  public static void main(String[] args) {
    Boat b1 = new Boat();        // Create a generic Boat object
    Sailboat b2 = new Sailboat(); // Create a Sailboat object (subclass of Boat)
    Rowboat b3 = new Rowboat();   // Create a Rowboat object (subclass of Boat)

    b2.setLength(32);            // Set the length of the sailboat to 32 units
    b1.move();                   // Call the move method on the generic boat
    b3.move();                   // Call the move method on the rowboat
    b2.move();                   // Call the move method on the sailboat
  }
}
