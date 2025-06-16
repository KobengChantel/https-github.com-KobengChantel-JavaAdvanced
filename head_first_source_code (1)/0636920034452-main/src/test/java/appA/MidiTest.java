package appA;

import org.junit.jupiter.api.Test;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

import static org.junit.jupiter.api.Assertions.*;

// This JUnit test opens a MIDI synthesizer and prints out all available instruments on the system.

class MidiTest {

  @Test
  void testInstruments() throws MidiUnavailableException {
    // Get the system's default MIDI synthesizer
    Synthesizer synthesizer = MidiSystem.getSynthesizer();

    // Open the synthesizer to access its instruments
    synthesizer.open();

    // Retrieve the available MIDI instruments (e.g., piano, guitar)
    Instrument[] orchestra = synthesizer.getAvailableInstruments();

    // Print each instrument to the console
    for (Instrument instrument : orchestra) {
      System.out.println(instrument);
    }

    // (Optional: you could add assertions to test specific instrument names/types)
  }

}
