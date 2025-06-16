package ch11;

import java.util.*;

// This class illustrates the limitations of generics in Java when dealing with inheritance hierarchies and collections.
public class TestGenerics2 {
  public static void main(String[] args) {
    new TestGenerics2().go();
  }

  public void go() {
    // Create a list of Animals containing Dogs and Cats
    List<Animal> animals = List.of(new Dog(), new Cat(), new Dog());
    // This works fine because the method expects a List<Animal>
    takeAnimals(animals);

    // Create a list of Dogs only
    List<Dog> dogs = List.of(new Dog(), new Dog());
    // This line is commented out because it would cause a compile-time error:
    // List<Dog> is NOT a subtype of List<Animal>, so it cannot be passed to takeAnimals
//    takeAnimals(dogs);
  }

  // Method accepts a list of Animals and calls eat() on each
  public void takeAnimals(List<Animal> animals) {
    for (Animal a : animals) {
      a.eat();
    }
  }
}
