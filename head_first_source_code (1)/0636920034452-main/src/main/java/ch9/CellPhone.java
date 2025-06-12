package ch9;

// The CellPhone class contains a private inner class Antenna, representing a component of the CellPhone.

public class CellPhone {
  // Private instance variable of type Antenna (inner class)
  private Antenna ant;

  // Private inner class representing the Antenna component of the CellPhone
  private class Antenna {
    // Inner class can have its own properties and methods (not shown here)
  }
}
