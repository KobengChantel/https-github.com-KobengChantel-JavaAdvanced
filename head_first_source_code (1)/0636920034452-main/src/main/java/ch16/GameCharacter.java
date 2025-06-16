package ch16;

import java.io.*;
import java.util.Arrays;

// This class defines a serializable GameCharacter with power, type, and an array of weapons, supporting saving/loading of its state.

public class GameCharacter implements Serializable {
  private final int power;         // Character's power level
  private final String type;       // Character's type or class (e.g., warrior, mage)
  private final String[] weapons;  // Array of weapons the character has

  // Constructor to initialize all fields
  public GameCharacter(int power, String type, String[] weapons) {
    this.power = power;
    this.type = type;
    this.weapons = weapons;
  }

  // Getter for power
  public int getPower() {
    return power;
  }

  // Getter for type
  public String getType() {
    return type;
  }

  // Returns the weapons array as a formatted string
  public String getWeapons() {
    return Arrays.toString(weapons);
  }
}
