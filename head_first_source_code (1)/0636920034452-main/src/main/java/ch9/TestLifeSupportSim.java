package ch9;

import java.util.ArrayList;

/**
 * The TestLifeSupportSim class simulates the creation of different types of
 * SimUnits (simulated units) and their management in a shared list.
 */
public class TestLifeSupportSim {

  /**
   * Main method to run the simulation.
   * It creates a shared ArrayList to store SimUnit objects, then
   * creates two radiator units and multiple retention bots.
   */
  public static void main(String[] args) {
    // Create an ArrayList to hold SimUnit objects
    ArrayList<SimUnit> aList = new ArrayList<SimUnit>();

    // Create two radiator units and add them to the list (assumed in constructors)
    V2Radiator v2 = new V2Radiator(aList);
    V3Radiator v3 = new V3Radiator(aList);

    // Create 20 RetentionBot units, each added to the list
    for (int z = 0; z < 20; z++) {
      RetentionBot ret = new RetentionBot(aList);
    }
  }
}

/**
 * The SimUnit class represents a simulated unit with a type and power usage.
 */
class SimUnit {
  // String indicating the type of the bot/unit
  String botType;

  /**
   * Constructor to create a SimUnit with a given type.
   *
   * @param type the type of the SimUnit
   */
  SimUnit(String type) {
    botType = type;
  }

  /**
   * Calculates the power usage based on the bot type.
   * Retention bots use less power than others.
   *
   * @return power consumption as an int
   */
  int powerUse() {
    if ("Retention".equals(botType)) {
      return 2;   // Retention bots use less power
    } else {
      return 4;   // Other types use more power
    }
  }
}
