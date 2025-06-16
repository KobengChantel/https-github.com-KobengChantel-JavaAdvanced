package ch13;

import javax.sound.midi.*;  // Imports the Java MIDI library for handling musical instrument digital interface tasks

// This program defines a method to test if a MIDI sequencer can be accessed, but does not yet execute anything.

public class PlayingMusic {

  // Method to attempt getting a MIDI sequencer
  public void play() {
    try {
      // Try to get the default system MIDI sequencer
      Sequencer sequencer = MidiSystem.getSequencer();
      System.out.println("Successfully got a sequencer");  // If successful, print confirmation
    } catch (MidiUnavailableException e) {
      // If getting the sequencer fails, print an error message
      System.out.println("Bummer");
    }
  }
}
