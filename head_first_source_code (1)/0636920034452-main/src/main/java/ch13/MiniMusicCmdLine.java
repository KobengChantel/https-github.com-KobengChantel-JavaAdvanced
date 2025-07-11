package ch13;

import javax.sound.midi.*;

import static javax.sound.midi.ShortMessage.*;

// This program plays a MIDI note on a specified instrument using command line arguments.

public class MiniMusicCmdLine {
  public static void main(String[] args) {
    MiniMusicCmdLine mini = new MiniMusicCmdLine();
    if (args.length < 2) {
      System.out.println("Don’t forget the instrument and note args");
    } else {
      int instrument = Integer.parseInt(args[0]);
      int note = Integer.parseInt(args[1]);
      mini.play(instrument, note);
    }
  }

  public void play(int instrument, int note) {
    try {
      Sequencer player = MidiSystem.getSequencer();
      player.open();

      Sequence seq = new Sequence(Sequence.PPQ, 4);
      Track track = seq.createTrack();

      // Change instrument (program) on channel 1
      ShortMessage msg1 = new ShortMessage();
      msg1.setMessage(PROGRAM_CHANGE, 1, instrument, 0);
      MidiEvent changeInstrument = new MidiEvent(msg1, 1);
      track.add(changeInstrument);

      // Note ON event on channel 1, velocity 100
      ShortMessage msg2 = new ShortMessage();
      msg2.setMessage(NOTE_ON, 1, note, 100);
      MidiEvent noteOn = new MidiEvent(msg2, 1);
      track.add(noteOn);

      // Note OFF event at tick 16
      ShortMessage msg3 = new ShortMessage();
      msg3.setMessage(NOTE_OFF, 1, note, 100);
      MidiEvent noteOff = new MidiEvent(msg3, 16);
      track.add(noteOff);

      player.setSequence(seq);
      player.start();

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
