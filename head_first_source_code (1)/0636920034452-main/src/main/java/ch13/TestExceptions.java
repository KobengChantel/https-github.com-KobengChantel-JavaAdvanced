package ch13;  // Declares this file is part of the ch13 package

// This program demonstrates try-catch-finally behavior by conditionally throwing a custom checked exception.

public class TestExceptions {

  public static void main(String[] args) {
    String test = "no";  // Input string used to control exception throwing

    try {
      System.out.println("start try");  // First message in the try block
      doRisky(test);                    // Call a method that might throw an exception
      System.out.println("end try");    // This line runs only if no exception is thrown
    } catch (ScaryException se) {
      System.out.println("scary exception");  // Handles ScaryException if thrown
    } finally {
      System.out.println("finally");    // Always runs whether or not an exception occurred
    }

    System.out.println("end of main");  // This always runs at the end
  }

  // This method conditionally throws a custom exception
  static void doRisky(String test) throws ScaryException {
    System.out.println("start risky");  // Indicates method execution started
    if ("yes".equals(test)) {
      throw new ScaryException();       // Throw custom exception if test equals "yes"
    }
    System.out.println("end risky");    // Runs only if no exception is thrown
  }
}

// Custom checked exception class
class ScaryException extends Exception {
}
