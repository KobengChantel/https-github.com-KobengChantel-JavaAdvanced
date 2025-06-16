package ch10;

import java.util.ArrayList;

public class Snippets {

  /**
   * Demonstrates some basic Math methods:
   * - round: rounds a floating number to nearest long
   * - min: returns smaller of two numbers
   * - abs: returns absolute value
   */
  void mathMethods() {
    long x = Math.round(42.2);      // rounds to 42
    int y = Math.min(56, 12);       // returns 12
    int z = Math.abs(-343);          // returns 343
  }

  /**
   * Returns the smaller of two integers using Math.min
   * @param a first integer
   * @param b second integer
   * @return smaller of a and b
   */
  public static int min(int a, int b) {
    // returns the smallest of a and b
    return Math.min(a, b);
  }

  /**
   * Demonstrates rounding float and double values to nearest int or long
   */
  void rounding() {
    int x = Math.round(-24.8f);   // returns -25
    int y = Math.round(24.45f);   // returns 24
    long z = Math.round(24.45);   // returns 24L (long)
  }

  /**
   * Shows autoboxing: converting primitive int to Integer object,
   * storing in an ArrayList, and unboxing back to int
   */
  void wrapInt() {
    int x = 32;
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(x);           // autoboxing: int to Integer
    int num = list.get(0); // unboxing: Integer to int
  }

  /**
   * Demonstrates Java wrapper classes for primitive types,
   * and how primitives are autoboxed into their wrapper classes.
   */
  void wrappers() {
    boolean b = true;
    Boolean bool = b;   // boolean to Boolean
    char c = 'a';
    Character chr = c;  // char to Character
    byte bt = 0;
    Byte bte = bt;      // byte to Byte
    short s = 1;
    Short sht = s;      // short to Short
    int i = 2;
    Integer intr = i;   // int to Integer
    long l = 3;
    Long lng = l;       // long to Long
    float f = 4;
    Float flt = f;      // float to Float
    double d = 5;
    Double dbl = d;     // double to Double
  }

  /**
   * Example of autoboxing with an ArrayList of Integer objects.
   * The primitive int is automatically wrapped/unwrapped.
   */
  public void autoboxing() {
    int x = 32;
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(x);          // autoboxing int -> Integer
    int num = list.get(0); // unboxing Integer -> int
  }

  /**
   * Parsing strings into primitive types using wrapper classes' parse methods.
   */
  static void parse() {
    String s = "2";
    int x = Integer.parseInt(s);        // parse "2" to int 2
    double d = Double.parseDouble("420.24"); // parse to double 420.24
    boolean b = Boolean.parseBoolean("True"); // parse to boolean true (case-insensitive)
  }

  /**
   * Demonstrates what happens if parsing fails:
   * Integer.parseInt with a non-numeric string throws NumberFormatException
   */
  static void badParse() {
    String t = "two";
    int y = Integer.parseInt(t);  // throws NumberFormatException
    System.out.println(y);
  }

  /**
   * Converts a double value to a String using concatenation with empty string.
   */
  void doubleToString1() {
    double d = 42.5;
    String doubleString = "" + d;
  }

  /**
   * Converts a double to String using Double.toString() method.
   */
  void doubleToString2() {
    double d = 42.5;
    String doubleString = Double.toString(d);
  }

  /**
   * Converts a double to String using String.valueOf().
   */
  void doubleToString3() {
    double d = 42.5;
    String doubleString = String.valueOf(d);
  }

  /**
   * Demonstrates basic String formatting for decimal numbers.
   */
  static void format() {
    String.format("I have %.2f, bugs to fix.", 476578.09876);
    // %.2f formats the number to 2 decimal places
  }

  /**
   * String formatting with comma as thousand separator.
   */
  static void formatWithCommas() {
    String.format("I have %,.2f, bugs to fix.", 476578.09876);
    // %,.2f formats with commas and 2 decimal places
  }

  /**
   * Formatting integer with %d specifier.
   */
  static void formatDecimal() {
    System.out.println(String.format("%d", 42));  // prints "42"
  }

  /**
   * Formatting float with 3 decimal places.
   */
  static void formatFloat() {
    System.out.println(String.format("%.3f", 42.000000)); // prints "42.000"
  }

  /**
   * Formats integer to hexadecimal string.
   */
  static void formatHex() {
    System.out.println(String.format("%x", 42)); // prints "2a" (hexadecimal)
  }

  /**
   * Formats integer as a character using ASCII code.
   */
  static void formatChar() {
    System.out.println(String.format("%c", 42)); // prints '*' (ASCII code 42)
  }

  /**
   * Main method to test formatting examples.
   */
  public static void main(String[] args) {
    formatChar();
  }
}
