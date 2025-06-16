package ch11;

import java.util.*;

/**
 * This class demonstrates the use of Java generics with bounded wildcards and type parameters
 * to work with lists of Animal objects and their subclasses, showing methods that accept,
 * return, and process these lists in a type-safe way.
 */
public class TestGenerics3 {
  public static void main(String[] args) {
    new TestGenerics3().go();
  }

  public void go() {
    // Create a list of Animals (Dog and Cat), then process them
    List<Animal> animals = List.of(new Dog(), new Cat(), new Dog());
    takeAnimals(animals);

    // Create a list of Dogs and process them with the same method that accepts Animals
    List<Dog> dogs = List.of(new Dog(), new Dog());
    takeAnimals(dogs);

    // Get a unique list of Dogs (copy of the input list)
    List<Dog> vaccinatedDogs = getUniqueAnimals(dogs);
    System.out.println(vaccinatedDogs);

    // Get a list of Animals (or subclasses) with an unknown specific subtype
    List<? extends Animal> uniqueAnimals2 = getUniqueAnimals2(dogs);
    System.out.println(uniqueAnimals2);
  }

  // Method that accepts a list of any subtype of Animal and calls eat() on each
  public void takeAnimals(List<? extends Animal> animals) {
    for (Animal a : animals) {
      a.eat();
    }
  }

  // Generic method that accepts a list of T, where T is a subtype of Animal, and calls eat()
  public <T extends Animal> void takeAnimals2(List<T> animals) {
    for (Animal a : animals) {
      a.eat();
    }
  }

  // Generic method that returns a new list (copy) of the input list of animals of type T
  public <T extends Animal> List<T> getUniqueAnimals(List<T> animals) {
    return new ArrayList<>(animals);
  }

  // Method that returns a fixed list containing a new Cat, accepting any list of Animals or subclasses
  public List<? extends Animal> getUniqueAnimals2(List<? extends Animal> animals) {
    return List.of(new Cat());
  }
}
