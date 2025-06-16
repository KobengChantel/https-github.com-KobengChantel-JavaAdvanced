package ch2;

import java.util.Random;

// This code defines a Player class with a guess method that randomly generates a number between 0 and 9 and stores it in the number field.
public class Player {
  public int number;  // Player's guessed number

  public void guess() {
    Random randomGenerator = new Random();         // Create a Random object
    number = randomGenerator.nextInt(10);          // Generate random number between 0 and 9
  }
}
