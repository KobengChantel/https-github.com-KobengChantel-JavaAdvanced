package ch7;

// This class demonstrates method overloading with addNums for different parameter types and overloaded setters for uniqueID.

public class Overloads {
  String uniqueID;  // Stores a unique identifier as a string

  // Adds two integers and returns the sum
  public int addNums(int a, int b) {
    return a + b;
  }

  // Adds two doubles and returns the sum
  public double addNums(double a, double b) {
    return a + b;
  }

  // Sets the uniqueID using a String after validation (not shown)
  public void setUniqueID(String theID) {
    // lots of validation code, and then:
    uniqueID = theID;
  }

  // Overloaded method to set uniqueID using an int by converting it to a String
  public void setUniqueID(int ssNumber) {
    String numString = "" + ssNumber;
    setUniqueID(numString);
  }
}
