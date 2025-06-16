package ch14;

import javax.sound.midi.*;

import static javax.sound.midi.ShortMessage.*;

// This program plays a MIDI sequence like MiniMusicPlayer1 but also listens for CONTROL_CHANGE events (controller 127) and prints "la" each time one occurs.

public class MiniMusicPlayer2 {
  public static void main(String[] args) {
    MiniMusicPlayer2 mini = new MiniMusicPlayer2();
    mini.go();
  }

  public void go() {
    try {
      Sequencer sequencer = MidiSystem.getSequencer(); // Get the default MIDI sequencer
      sequencer.open();                                // Open the sequencer

      int[] eventsIWant = {127};                        // Controller event number to listen for
      // Add a listener that prints "la" whenever a controller event with controller number 127 is encountered during playback
      sequencer.addControllerEventListener(event -> System.out.println("la"), eventsIWant);

      Sequence seq = new Sequence(Sequence.PPQ, 4);   // Create a new MIDI sequence with timing resolution
      Track track = seq.createTrack();                 // Create a track in the sequence

      // Add MIDI events to the track:
      for (int i = 5; i < 60; i += 4) {
        track.add(makeEvent(NOTE_ON, 1, i, 100, i));         // Note ON at tick i
        track.add(makeEvent(CONTROL_CHANGE, 1, 127, 0, i));  // Controller event 127 at tick i (to trigger listener)
        track.add(makeEvent(NOTE_OFF, 1, i, 100, i + 2));    // Note OFF at tick i+2
      }

      sequencer.setSequence(seq);                  // Load the sequence into the sequencer
      sequencer.setTempoInBPM(220);                // Set tempo to 220 BPM
      sequencer.start();                           // Start playback
    } catch (Exception ex) {
      ex.printStackTrace();                        // Print any exceptions
    }
  }

  // Helper method to create a MIDI event with specified command, channel, data1, data2, and tick
  public static MidiEvent makeEvent(int cmd, int chnl, int one, int two, int tick) {
    MidiEvent event = null;
    try {
      ShortMessage msg = new ShortMessage();
      msg.setMessage(cmd, chnl, one, two);
      event = new MidiEvent(msg, tick);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return event;
  }
}
