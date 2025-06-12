package ch8;

import ch7.Cat;
import ch7.Dog;

// This program demonstrates polymorphism by adding different Animal objects (Dog and Cat) to a custom list.

public class AnimalTestDrive {
  public static void main(String[] args) {
    MyAnimalList list = new MyAnimalList(); // Create an instance of MyAnimalList to store Animal objects
    Dog dog = new Dog();                    // Create a Dog object
    Cat cat = new Cat();                    // Create a Cat object
    list.add(dog);                          // Add the Dog to the list
    list.add(cat);                          // Add the Cat to the list
  }
}
