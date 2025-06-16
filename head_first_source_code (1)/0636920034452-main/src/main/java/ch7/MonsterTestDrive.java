package ch7;

// This code demonstrates polymorphism with an array of Monster objects where subclasses override or define the frighten method differently.

public class MonsterTestDrive {
  public static void main(String[] args) {
    Monster[] monsters = new Monster[3];  // Array to hold Monster and its subclass instances
    monsters[0] = new Vampire();          // Vampire instance stored as Monster reference
    monsters[1] = new Dragon();           // Dragon instance stored as Monster reference
    monsters[2] = new Monster();          // Plain Monster instance

    for (int i = 0; i < monsters.length; i++) {
      // uncomment to do the exercise
      // monsters[i].frighten(i);         // Polymorphic call to frighten, if defined in subclasses
    }
  }
}

class Monster {
  // No frighten method defined here, so calling frighten on a Monster reference
  // will fail unless the method is defined in the subclass or Monster itself.
}

class Vampire extends Monster {
  // Vampire does not define frighten, so it inherits none or must implement it for polymorphism.
}

class Dragon extends Monster {
  // Overrides or adds the frighten method that takes an int parameter to simulate scaring behavior
  boolean frighten(int degree) {
    System.out.println("breathe fire");  // Prints a message representing the dragon's scary action
    return true;                         // Returns true to indicate successful frighten action
  }
}


// The commented-out methods below represent possible versions of frighten or scare
// methods to illustrate overloading, overriding, or invalid method signatures
// in subclasses, showing how Java handles method resolution and polymorphism.


//boolean frighten(int d) {
//  System.out.println("arrrgh");
//  return true;
//}
//boolean frighten(int x) {
//  System.out.println("a bite?");
//  return false;
//}
//
//boolean frighten(int x) {
//  System.out.println("arrrgh");
//  return true;
//}
//int frighten(int f) {
//  System.out.println("a bite?");
//  return 1;
//}
//
//boolean frighten(int x) {
//  System.out.println("arrrgh");
//  return false;
//}
//boolean scare(int x) {
//  System.out.println("a bite?");
//  return true;
//}
//
//boolean frighten(int z) {
//  System.out.println("arrrgh");
//  return true;
//}
//boolean frighten(byte b) {
//  System.out.println("a bite?");
//  return true;
//}