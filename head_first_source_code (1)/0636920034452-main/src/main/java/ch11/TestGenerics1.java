package ch11;

import java.util.List;

// This class demonstrates using generics with a list of Animal objects and calling their common method.
public class TestGenerics1 {
  public static void main(String[] args) {
    // Create a list of animals including Dogs and Cats
    List<Animal> animals = List.of(new Dog(), new Cat(), new Dog());

    // Pass the list to a method that makes each animal eat
    takeAnimals(animals);
  }

  // Method that accepts a list of Animal objects and calls eat() on each
  public static void takeAnimals(List<Animal> animals) {
    for (Animal a : animals) {
      a.eat();
    }
  }
}

// Abstract base class representing an animal with an eat method
abstract class Animal {
  void eat() {
    System.out.println("animal eating");
  }
}

// Dog class extends Animal and has a bark method (not used here)
class Dog extends Animal {
  void bark() {
  }
}

// Cat class extends Animal and has a meow method (not used here)
class Cat extends Animal {
  void meow() {
  }
}
