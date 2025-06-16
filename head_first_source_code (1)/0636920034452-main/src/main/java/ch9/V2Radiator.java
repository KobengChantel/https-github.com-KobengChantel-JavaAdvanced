package ch9;

import java.util.ArrayList;

/**
 * The V2Radiator class creates multiple SimUnit objects of type "V2Radiator"
 * and adds them to the provided list.
 */
class V2Radiator {
  /**
   * Constructor that adds 5 V2Radiator SimUnit objects to the list.
   * @param list the ArrayList to store SimUnit objects
   */
  V2Radiator(ArrayList<SimUnit> list) {
    for (int x = 0; x < 5; x++) {
      list.add(new SimUnit("V2Radiator"));
    }
  }
}

/**
 * The V3Radiator class extends V2Radiator and adds more SimUnits.
 * It calls the superclass constructor to add V2Radiators,
 * then adds 10 V3Radiator SimUnit objects to the same list.
 */
class V3Radiator extends V2Radiator {
  /**
   * Constructor that first calls the V2Radiator constructor,
   * then adds 10 V3Radiator SimUnit objects to the list.
   * @param lglist the ArrayList to store SimUnit objects
   */
  V3Radiator(ArrayList<SimUnit> lglist) {
    super(lglist);  // Add 5 V2Radiator units first
    for (int g = 0; g < 10; g++) {
      lglist.add(new SimUnit("V3Radiator"));
    }
  }
}

/**
 * The RetentionBot class creates a single SimUnit of type "Retention"
 * and adds it to the provided list.
 */
class RetentionBot {
  /**
   * Constructor that adds one Retention SimUnit to the list.
   * @param rlist the ArrayList to store SimUnit objects
   */
  RetentionBot(ArrayList<SimUnit> rlist) {
    rlist.add(new SimUnit("Retention"));
  }
}
