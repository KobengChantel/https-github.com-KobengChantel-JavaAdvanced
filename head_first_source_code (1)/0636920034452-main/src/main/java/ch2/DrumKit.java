package ch2;

// This code defines a DrumKit class with two drum parts and their sounds, then tests playing them and conditionally plays the snare based on its state.
class DrumKit {
  boolean topHat = true;   // Indicates if the topHat cymbal is available
  boolean snare = true;    // Indicates if the snare drum is available

  void playTopHat() {
    System.out.println("ding ding da-ding");  // Prints the sound of the topHat cymbal
  }

  void playSnare() {
    System.out.println("bang bang ba-bang");  // Prints the sound of the snare drum
  }
}

class DrumKitTestDrive {
  public static void main(String[] args) {
    DrumKit d = new DrumKit();   // Create a new DrumKit object named d
    d.playSnare();               // Play the snare sound
    d.snare = false;             // Set the snare availability to false (unavailable)
    d.playTopHat();              // Play the topHat sound

    if (d.snare == true) {       // Check if snare is available
      d.playSnare();             // If available, play the snare sound again
    }
  }
}
