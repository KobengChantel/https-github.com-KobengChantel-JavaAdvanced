package ch1;

import java.io.FileNotFoundException;

// This program creates a Dog object, performs some calculations and conditional logic, parses a string to an integer,
// attempts to read a file while handling exceptions, and includes placeholder methods for dog actions like bark and play.

public class FirstJavaClass {
  private static int x;  // Static variable shared across the class

  public static void main(String[] args) {
    int size = 27;                    // Local variable `size` initialized
    String name = "Fido";            // Dog's name
    Dog myDog = new Dog(name, size); // Create a Dog object
    x = size - 5;                    // Assign x = 22

    if (x < 15)                      // If x is less than 15
      myDog.bark(8);                // Dog barks (method currently empty)

    while (x > 3) {                  // Infinite loop since x never changes here
      myDog.play();                 // Dog plays (method currently empty)
    }

    int[] numList = {2, 4, 6, 8};    // Array initialization (not used)
    System.out.print("Hello");       // Print Hello
    System.out.print("Dog: " + name); // Print Dog's name

    String num = "8";               // String containing a number
    int z = Integer.parseInt(num);  // Convert string to integer

    try {
      readTheFile("myFile.txt");    // Attempt to read file
    } catch (FileNotFoundException ex) {
      System.out.print("File not found.");  // Handle missing file
    }
  }

  // Method signature declaring it throws FileNotFoundException
  private static void readTheFile(String s) throws FileNotFoundException {
    // No implementation
  }
}

// Dog class definition
class Dog {
  private final String name;
  private final int size;

  public Dog(String name, int size) {
    this.name = name;
    this.size = size;
  }

  public void bark(int i) {
    // Bark method placeholder
  }

  public void play() {
    // Play method placeholder
  }
}
