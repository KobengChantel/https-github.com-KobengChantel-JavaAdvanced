package ch13;  // This class belongs to the ch13 package

// This program demonstrates exception handling in Java using try-catch blocks, null references, and a custom checked exception.

public class Snippets {

  private boolean abandonAllHope;     // Used to determine whether to throw a custom exception
  private Snippets anObject;          // A reference to another Snippets object (can be null)
  private Laundry laundry;            // Reference to a Laundry object (class not defined here)

  // Demonstrates try-catch logic with potential for NullPointerException
  void testTryCatch() {
    try {
      Risky x = new Risky();            // Create a new Risky object
      Foo f = x.doRiskyThing();         // Method returns null to simulate a risky action
      int b = f.getNum();               // This will throw NullPointerException if f is null
    } catch (Exception e) {
      System.out.println("failed");     // Catches and reports the exception
    }
    System.out.println("We made it!");  // Runs regardless of an exception
  }

  // Method that may throw a custom checked exception
  public void takeRisk() throws BadException {
    if (abandonAllHope) {
      throw new BadException();         // Throws custom exception if abandonAllHope is true
    }
  }

  // Calls takeRisk() and handles the BadException
  public void crossFingers() {
    try {
      anObject.takeRisk();              // Could cause NullPointerException if anObject is null
    } catch (BadException e) {
      System.out.println("Aaargh!");    // Handles the custom exception
      e.printStackTrace();              // Prints stack trace for debugging
    }
  }

  // Placeholder for exception handling (commented out)
  void catchExceptions() {
//    try { // Assumes Laundry class and doLaundry() may throw ShirtException
//      laundry.doLaundry();
//
//    } catch (ShirtException shex) {
//      // recovery code    // Placeholder for recovery logic
//    }
  }

}

// Class representing a risky operation
class Risky {
  public Foo doRiskyThing() {
    return null;  // Always returns null to simulate a dangerous situation
  }
}

// Simple class with a method returning an integer
class Foo {
  public int getNum() {
    return 0;  // Returns a dummy value
  }
}
