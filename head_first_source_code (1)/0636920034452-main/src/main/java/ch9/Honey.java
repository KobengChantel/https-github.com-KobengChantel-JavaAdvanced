package ch9;

// This code demonstrates object references and shared references to the same Honey object
// across multiple classes and arrays.

class Bees {
  Honey[] beeHoney;  // Array to hold references to Honey objects related to Bees
}

class Raccoon {
  Kit rk;           // Reference to a Kit object
  Honey rh;         // Reference to a Honey object
}

class Kit {
  Honey honey;      // Reference to a Honey object
}

class Bear {
  Honey hunny;      // Reference to a Honey object (note the playful variable name)
}

public class Honey {
  public static void main(String[] args) {
    Honey honeyPot = new Honey();  // Create one Honey object

    // Create an array of Honey references all pointing to the same Honey object
    Honey[] ha = {honeyPot, honeyPot, honeyPot, honeyPot};

    Bees bees = new Bees();
    bees.beeHoney = ha;            // Assign the array of Honey references to bees

    Bear[] bears = new Bear[5];    // Create an array to hold Bear objects
    for (int i = 0; i < 5; i++) {
      bears[i] = new Bear();       // Create each Bear object
      bears[i].hunny = honeyPot;   // All Bears reference the same Honey object
    }

    Kit kit = new Kit();
    kit.honey = honeyPot;          // Kit references the same Honey object

    Raccoon raccoon = new Raccoon();
    raccoon.rh = honeyPot;         // Raccoon references the same Honey object
    raccoon.rk = kit;              // Raccoon references the Kit object

    kit = null;                    // Remove the reference to Kit from main, Kit still referenced by raccoon
  } // end of main
}
