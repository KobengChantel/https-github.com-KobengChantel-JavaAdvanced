package ch13;

import javax.sound.midi.*;  // Imports MIDI classes needed for sound synthesis and sequencing

// This program attempts to get a MIDI sequencer and prints a message based on success or failure.

public class MusicTest1 {

  // The play() method tries to get a MIDI sequencer and prints a success or error message
  public void play() {
    try {
      // Attempt to get a default MIDI sequencer from the system
      Sequencer sequencer = MidiSystem.getSequencer();
      System.out.println("Successfully got a sequencer");  // Success message
    } catch(MidiUnavailableException e) {
      // If the sequencer is not available, print an error message
      System.out.println("Bummer");
    }
  }

  // Main method to run the program
  public static void main(String[] args) {
    MusicTest1 mt = new MusicTest1();  // Create an instance of MusicTest1
    mt.play();  // Call the play method
  }
}
