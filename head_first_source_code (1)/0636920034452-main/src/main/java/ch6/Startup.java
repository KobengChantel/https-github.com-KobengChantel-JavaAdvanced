package ch6;

import java.util.ArrayList;

// This class models a simple "Startup" game object that stores its position and checks whether a user's guess hits, misses, or sinks it.

public class Startup {
  private ArrayList<String> locationCells;  // Stores the coordinates of the startup (like "a3", "a4", etc.)
  private String name;                      // Name of the startup

  // Sets the location of the startup
  public void setLocationCells(ArrayList<String> loc) {
    locationCells = loc;
  }

  // Sets the name of the startup
  public void setName(String n) {
    name = n;
  }

  // Checks the user's guess against the startup's location
  public String checkYourself(String userInput) {
    String result = "miss";                                // Default result
    int index = locationCells.indexOf(userInput);          // Check if guess is in locationCells
    if (index >= 0) {
      locationCells.remove(index);                         // Remove the hit location
      if (locationCells.isEmpty()) {                       // If all cells are hit
        result = "kill";
        System.out.println("Ouch! You sunk " + name + "   : ( ");
      } else {
        result = "hit";                                    // Partial hit
      }
    }
    return result;                                          // Return result: "miss", "hit", or "kill"
  }
}
