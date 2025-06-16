package ch8;

import ch7.Dog;

// This class defines a custom list that holds up to 5 Dog objects.

public class MyDogList {
  // An array to store Dog objects with a fixed size of 5
  private Dog[] dogs = new Dog[5];

  // Keeps track of the next empty position in the array
  private int nextIndex = 0;

  // Adds a Dog object to the list if there is available space
  public void add(Dog d) {
    if (nextIndex < dogs.length) {                // Check if there is room in the array
      dogs[nextIndex] = d;                        // Place the Dog object at the current index
      System.out.println("Dog added at " + nextIndex); // Output confirmation message
      nextIndex++;                                // Move to the next available index
    }
  }
}
