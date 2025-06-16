package ch10;

// Superclass with a static block and constructor
class StaticSuper {
  // Static initialization block in superclass runs once when the class is loaded
  static {
    System.out.println("super static block");
  }

  // Constructor of superclass, runs whenever an instance is created
  StaticSuper() {
    System.out.println("super constructor");
  }
}

public class StaticTests extends StaticSuper {
  // Static variable to hold a random number
  static int rand;

  // Static block in subclass, runs once when subclass is loaded, after superclass static block
  static {
    rand = (int) (Math.random() * 6);  // initialize rand with a random number from 0 to 5
    System.out.println("static block " + rand);
  }

  // Constructor of subclass, runs when an instance of StaticTests is created
  StaticTests() {
    System.out.println("constructor");
  }

  public static void main(String[] args) {
    System.out.println("in main");    // prints before any instance creation
    StaticTests st = new StaticTests(); // creates an instance, triggers constructor chain
  }
}
