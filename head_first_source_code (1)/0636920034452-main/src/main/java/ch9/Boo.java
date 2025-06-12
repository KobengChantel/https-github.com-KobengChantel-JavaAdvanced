package ch9;

// The Boo class provides multiple constructors with different parameter types for object creation.
public class Boo {
  public Boo(int i) {
    // Constructor accepting an integer
  }

  public Boo(String s) {
    // Constructor accepting a string
  }

  public Boo(String s, int i) {
    // Constructor accepting a string and an integer
  }
}

// SonOfBoo extends Boo and demonstrates calling different superclass constructors using super()
class SonOfBoo extends Boo {

  // No-argument constructor calls Boo(String) constructor with "boo"
  public SonOfBoo() {
    super("boo");
  }

  // Constructor with an int calls Boo(String) constructor with "Fred"
  public SonOfBoo(int i) {
    super("Fred");
  }

  // Constructor with a String calls Boo(int) constructor with 42
  public SonOfBoo(String s) {
    super(42);
  }

  // Commented out: Constructor with int and String parameters - no implementation
  // public SonOfBoo(int i, String s) {
  // }

  // Commented out: Constructor with three String parameters calls Boo(String, int)
  // public SonOfBoo(String a, String b, String c) {
  //   super(a, b);
  // }

  // Constructor with two ints calls Boo(String, int) constructor with "man" and second int
  public SonOfBoo(int i, int j) {
    super("man", j);
  }

  // Commented out: Constructor with three ints, attempts to call Boo(int, String) (does not exist)
  // public SonOfBoo(int i, int x, int y) {
  //   super(i, "star");
  // }
}
