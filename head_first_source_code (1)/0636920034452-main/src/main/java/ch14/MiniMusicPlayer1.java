package ch14;

import javax.sound.midi.*;

import static javax.sound.midi.ShortMessage.*;

// This program creates a MIDI sequencer that plays a sequence of notes stepping by 4 from pitch 5 to 60 at a fast tempo.

public class MiniMusicPlayer1 {
  public static void main(String[] args) {
    try {
      Sequencer sequencer = MidiSystem.getSequencer();  // Get the default MIDI sequencer
      sequencer.open();                                  // Open the sequencer to prepare it

      Sequence seq = new Sequence(Sequence.PPQ, 4);     // Create a new sequence with timing based on pulses per quarter note
      Track track = seq.createTrack();                   // Create a track in the sequence

      // Loop to add NOTE_ON and NOTE_OFF events for notes starting at 5 up to 60, stepping by 4
      for (int i = 5; i < 61; i += 4) {
        track.add(makeEvent(NOTE_ON, 1, i, 100, i));        // Note ON event for note 'i' on channel 1 with velocity 100 at tick i
        track.add(makeEvent(NOTE_OFF, 1, i, 100, i + 2));   // Note OFF event for note 'i' at tick i+2 to stop the note
      }

      sequencer.setSequence(seq);               // Load the sequence into the sequencer
      sequencer.setTempoInBPM(220);             // Set tempo to 220 beats per minute (very fast)
      sequencer.start();                        // Start playing the sequence
    } catch (Exception ex) {
      ex.printStackTrace();                     // Print any errors
    }
  }

  // Helper method to create a MidiEvent with the given parameters:
  // cmd = command (e.g., NOTE_ON or NOTE_OFF)
  // chnl = MIDI channel
  // one = note number or instrument, depending on command
  // two = velocity or other data, depending on command
  // tick = time at which event occurs in sequence
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
