package ch3;

// This class demonstrates valid and invalid Java variable declarations, literal assignments, and the use of reserved keywords.

public class ExampleDeclarations {

  // This method shows how to declare variables with different data types and assign values to them.
  void declarations() {
    int x;                  // Declares an integer variable x
    x = 234;                // Assigns 234 to x
    byte b = 89;            // Declares and initializes a byte variable b
    boolean isFun = true;   // Declares and initializes a boolean variable isFun
    double d = 3456.98;     // Declares and initializes a double variable d
    char c = 'f';           // Declares and initializes a character variable c
    int z = x;              // Declares an int z and assigns it the value of x
    boolean isPunkRock;
    isPunkRock = false;     // Declares and assigns a boolean variable
    boolean powerOn;
    powerOn = isFun;        // Assigns the value of isFun to powerOn
    long big = 3456789L;    // Declares and initializes a long variable with suffix L
    float f = 32.5f;        // Declares and initializes a float variable with suffix f
  }

  // This method shows how to declare variables with literals directly assigned to them.
  void declareLiterals() {
    int x = 234;            // Integer literal

    int size = 32;          // Another integer literal
    char initial = 'j';     // Character literal
    double d = 456.709;     // Double literal
    boolean isLearning;
    isLearning = true;      // Boolean literal
    int y = x + 456;        // Expression using a literal
  }

  // This method shows identifiers that are invalid variable names because they are reserved keywords in Java.
  void invalidNames() {
    // The following lines are commented out because they contain reserved words that cannot be used as variable names.
    // Examples include: int int; int class; int public; etc.
    // Attempting to use these would result in compile-time errors.

    // The uncommented lines use valid identifiers that are not Java keywords.
    int exports;
    int module;
    int open;
    int opens;
    int permits;
    int provides;
    int record;
    int requires;
    int sealed;
    int to;
    int transitive;
    int uses;
    int var;
    int with;
    int yield;
  }
}
