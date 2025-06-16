package ch7;

import org.junit.jupiter.api.Test;

// This test class demonstrates creating an array of different Animal subclasses and invoking their eat and roam behaviors.
public class AnimalTest {

  @Test
  void createAnimalsArray() {
    // Create an array to hold 5 Animal objects
    Animal[] animals = new Animal[5];

    // Initialize each element with a different subclass of Animal
    animals[0] = new Dog();
    animals[1] = new Cat();
    animals[2] = new Wolf();
    animals[3] = new Hippo();
    animals[4] = new Lion();

    // Iterate over each Animal in the array and call their eat and roam methods
    for (Animal animal : animals) {
      animal.eat();
      animal.roam();
    }

  }
}
