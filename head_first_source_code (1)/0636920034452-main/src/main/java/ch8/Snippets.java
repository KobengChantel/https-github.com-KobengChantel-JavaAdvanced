package ch8;

import ch7.Dog;

// This class demonstrates how returning a generic Object can be assigned to an Object reference without casting.
public class Snippets {

  public void go() {
    Dog aDog = new Dog();              // Create a Dog instance
    Object sameDog = getObject(aDog); // Assign returned Object from getObject() to an Object reference (works fine)
  }

  // Returns the input object as type Object
  public Object getObject(Object o) {
    return o;
  }
}

// This class illustrates a common compile-time error when assigning a generic Object return to a more specific type without casting.
class BadDog {

  public void go() {
    Dog aDog = new Dog();
    // This line does not compile because getObject returns Object,
    // which cannot be assigned directly to a Dog variable without an explicit cast
    // Dog sameDog = getObject(aDog);
  }

  // Returns the input object as type Object
  public Object getObject(Object o) {
    return o;
  }
}
