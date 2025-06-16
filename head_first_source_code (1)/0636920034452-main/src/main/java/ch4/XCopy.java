package ch4;

// This code demonstrates passing a primitive int to a method, doubling its value inside the method, and showing that the original variable remains unchanged outside the method.

class XCopy {

  public static void main(String[] args) {
    int orig = 42;                 // Original integer value
    XCopy x = new XCopy();         // Create an instance of XCopy
    int y = x.go(orig);            // Call method go with orig, which returns doubled value
    System.out.println(orig + " " + y);  // Print original and modified values
  }

  int go(int arg) {
    arg = arg * 2;                 // Double the argument value
    return arg;                    // Return doubled value
  }
}
