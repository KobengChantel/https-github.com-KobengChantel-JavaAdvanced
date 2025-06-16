package ch4;

// This code defines a method to calculate the area of a rectangle and demonstrates various valid and invalid calls to it, illustrating method overloading and type compatibility rules in Java.

public class Sharpen {
  int calcArea(int height, int width) {
    return height * width;  // Returns the product of height and width
  }

  void callCalcArea() {
    int a = calcArea(7, 12);    // Valid call with two int arguments
    short c = 7;
    calcArea(c, 15);             // Valid: short can be promoted to int

//    int d = calcArea(57);      // Invalid: only one argument provided

    calcArea(2, 3);              // Valid call, result not stored

    long t = 42;
//    int f = calcArea(t, 17);   // Invalid: long cannot be passed where int expected

//    int g = calcArea();        // Invalid: no arguments provided

//    calcArea();                // Invalid: no arguments provided

//    byte h = calcArea(4, 20); // Invalid: return type int cannot be assigned to byte without casting

//    int j = calcArea(2, 3, 5); // Invalid: method expects 2 parameters, 3 given
  }
}
