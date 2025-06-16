package ch8;

import ch7.Animal;

// This class represents a simple custom list that can store up to 5 Animal objects.

public class MyAnimalList {

  // An array to hold Animal objects, with a maximum size of 5
  private Animal[] animals = new Animal[5];

  // Tracks the next available index in the array
  private int nextIndex = 0;

  // Adds an Animal to the array if there is space available
  public void add(Animal a) {
    if (nextIndex < animals.length) {        // Check if the array has space
      animals[nextIndex] = a;                // Add the Animal at the current index
      System.out.println("Animal added at " + nextIndex); // Confirm addition
      nextIndex++;                           // Move to the next index
    }
  }
}
