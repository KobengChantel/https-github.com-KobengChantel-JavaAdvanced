package ch11;

import java.util.*;

/**
 * This class illustrates the use of generic methods with bounded type parameters
 * and wildcard types to process lists of Animal objects and their subclasses,
 * demonstrating how to return copied or fixed lists in a type-safe manner.
 */
public class TestGenerics4 {
  public static void main(String[] args) {
    new TestGenerics4().go();
  }

  public void go() {
    // Create a list of Dogs and get a copied list back
    List<Dog> dogs = List.of(new Dog(), new Dog());
    List<Dog> vaccinatedDogs = takeAnimals(dogs);
    System.out.println(vaccinatedDogs);

    // Create a list of Animals (Dogs and Cat), get a copied list back
    List<Animal> animals = List.of(new Dog(), new Cat(), new Dog());
    List<Animal> vaccinatedAnimals = takeAnimals(animals);
    System.out.println(vaccinatedAnimals);

    // Use a method that returns a fixed list of Animals or subclasses, accepting Dogs list
    List<? extends Animal> vaccinatedSomethings = takeAnimals2(dogs);
    System.out.println(vaccinatedSomethings);
  }

  // Generic method returning a new ArrayList copy of the input list of type T (where T extends Animal)
  public <T extends Animal> List<T> takeAnimals(List<T> animals) {
    return new ArrayList<>(animals);
  }

  // Method that accepts a list of Animals or subclasses and returns a fixed list containing a Cat
  public List<? extends Animal> takeAnimals2(List<? extends Animal> animals) {
    return List.of(new Cat());
  }
}
