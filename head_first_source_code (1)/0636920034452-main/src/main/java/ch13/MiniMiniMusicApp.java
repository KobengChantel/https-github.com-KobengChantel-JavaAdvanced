package ch13;

import javax.sound.midi.*;

// This class demonstrates basic MIDI sequencing in Java by creating and playing a simple note.

public class MiniMiniMusicApp {

  public static void main(String[] args) {
    MiniMiniMusicApp mini = new MiniMiniMusicApp();
    mini.play();
  }

  public void play() {
    try {
      // Get and open the MIDI sequencer
      Sequencer player = MidiSystem.getSequencer();
      player.open();

      // Create a new sequence with timing resolution (PPQ) and division 4
      Sequence seq = new Sequence(Sequence.PPQ, 4);

      // Create a track in the sequence
      Track track = seq.createTrack();

      // Create a "note on" message (144 = Note On command, channel 1, note 44, velocity 100)
      ShortMessage msg1 = new ShortMessage();
      msg1.setMessage(144, 1, 44, 100);
      MidiEvent noteOn = new MidiEvent(msg1, 1);
      track.add(noteOn);

      // Create a "note off" message (128 = Note Off command, same note and velocity)
      ShortMessage msg2 = new ShortMessage();
      msg2.setMessage(128, 1, 44, 100);
      MidiEvent noteOff = new MidiEvent(msg2, 16);
      track.add(noteOff);

      // Set the sequence in the player and start playing
      player.setSequence(seq);
      player.start();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
