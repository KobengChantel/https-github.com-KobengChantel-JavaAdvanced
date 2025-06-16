package ch3;

// This class demonstrates valid and invalid assignments involving primitive data types and highlights Java's type compatibility rules.

public class Sharpen {
  void sharpen() {
    // int x = 34.5;          // Invalid: cannot assign a decimal (double) to an int
    // boolean boo = x;       // Invalid: cannot assign an int to a boolean

    int g = 17;               // Declare and initialize int g
    int y = g;                // Copy value of g to y
    y = y + 10;               // Add 10 to y

    short s;
    // s = y;                 // Invalid without explicit cast: y is int, s is short

    byte b = 3;               // Declare and initialize byte b
    byte v = b;               // Valid: assigning one byte to another
    short n = 12;             // Declare and initialize short n
    // v = n;                 // Invalid: cannot assign short to byte without cast

    // byte k = 128;          // Invalid: byte range is -128 to 127; 128 is too large
  }
}
