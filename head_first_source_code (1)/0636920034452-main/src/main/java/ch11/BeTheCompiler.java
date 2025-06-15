package ch11;

import java.util.ArrayList;
import java.util.List;

// This program demonstrates how Java generics work with inheritance, particularly using bounded wildcards and type-specific lists.

public class BeTheCompiler {
  public static void main(String[] args) {
    // This works: ArrayList of Animal is passed to takeAnimals (expects List<Animal>)
    takeAnimals(new ArrayList<Animal>());

    // These won't compile because types must match exactly or use wildcards
    // takeDogs(new ArrayList<Animal>());     // ❌ List<Animal> is not a List<Dog>
    // takeAnimals(new ArrayList<Dog>());     // ❌ List<Dog> is not a List<Animal>

    // This works due to Java's type inference (Diamond Operator assumes Dog)
    takeDogs(new ArrayList<>());

    // This works: matching List<Dog> type
    List<Dog> dogs = new ArrayList<>();
    takeDogs(dogs);

    // Works because List<Dog> is accepted by List<? extends Animal>
    takeSomeAnimals(new ArrayList<Dog>());

    // Works due to type inference with wildcard `? extends Animal`
    takeSomeAnimals(new ArrayList<>());

    // Works: List<Animal> fits ? extends Animal
    takeSomeAnimals(new ArrayList<Animal>());

    // Same as above, but assigned to a variable first
    List<Animal> animals = new ArrayList<>();
    takeSomeAnimals(animals);

    // List<Object> created
    List<Object> objects = new ArrayList<>();

    // These won't compile: method expects ArrayList<Object> specifically
    // takeObjects(objects);                // ❌ Parameter is List<Object>, not ArrayList<Object>
    // takeObjects(new ArrayList<Dog>());  // ❌ Dog is not Object for this method

    // This works: method accepts ArrayList<Object>
    takeObjects(new ArrayList<Object>());
  }

  // Accepts only a List of Dog objects
  private static void takeDogs(List<Dog> dogs) {
    // do something
  }

  // Accepts only a List of Animal objects
  private static void takeAnimals(List<Animal> animals) {
    // do something
  }

  // Accepts a List of any type that is a subclass of Animal
  private static void takeSomeAnimals(List<? extends Animal> animals) {
    // do something
  }

  // Accepts only an ArrayList of Object type
  private static void takeObjects(ArrayList<Object> objects) {
    // do something
  }
}
