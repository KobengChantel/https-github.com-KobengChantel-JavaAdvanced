package ch15;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static javax.sound.midi.ShortMessage.*;

// This program creates a graphical drum machine allowing users to compose and play rhythmic patterns with MIDI sounds using a 16x16 grid of checkboxes and tempo controls.

public class BeatBox {
  private ArrayList<JCheckBox> checkboxList; // List of checkboxes representing beats for each instrument
  private Sequencer sequencer;               // MIDI sequencer to play the rhythm
  private Sequence sequence;                 // MIDI sequence that holds tracks
  private Track track;                       // MIDI track for events

  // Names and corresponding MIDI percussion instrument numbers
  String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat",
          "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap",
          "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga",
          "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo",
          "Open Hi Conga"};
  int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

  public static void main(String[] args) {
    new BeatBox().buildGUI();
  }

  public void buildGUI() {
    JFrame frame = new JFrame("Cyber BeatBox");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    BorderLayout layout = new BorderLayout();
    JPanel background = new JPanel(layout);
    background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    // Vertical box to hold control buttons (Start, Stop, Tempo Up, Tempo Down)
    Box buttonBox = new Box(BoxLayout.Y_AXIS);

    JButton start = new JButton("Start");
    start.addActionListener(e -> buildTrackAndStart()); // Build and start playing when clicked
    buttonBox.add(start);

    JButton stop = new JButton("Stop");
    stop.addActionListener(e -> sequencer.stop());      // Stop playback when clicked
    buttonBox.add(stop);

    JButton upTempo = new JButton("Tempo Up");
    upTempo.addActionListener(e -> changeTempo(1.03f)); // Increase tempo by 3%
    buttonBox.add(upTempo);

    JButton downTempo = new JButton("Tempo Down");
    downTempo.addActionListener(e -> changeTempo(0.97f)); // Decrease tempo by 3%
    buttonBox.add(downTempo);

    // Vertical box to display instrument labels aligned with checkbox rows
    Box nameBox = new Box(BoxLayout.Y_AXIS);
    for (String instrumentName : instrumentNames) {
      JLabel instrumentLabel = new JLabel(instrumentName);
      instrumentLabel.setBorder(BorderFactory.createEmptyBorder(4, 1, 4, 1));
      nameBox.add(instrumentLabel);
    }

    background.add(BorderLayout.EAST, buttonBox); // Buttons on right side
    background.add(BorderLayout.WEST, nameBox);   // Instrument names on left side

    frame.getContentPane().add(background);

    // Main panel with 16x16 grid of checkboxes representing beats per instrument
    GridLayout grid = new GridLayout(16, 16);
    grid.setVgap(1);
    grid.setHgap(2);
    JPanel mainPanel = new JPanel(grid);
    background.add(BorderLayout.CENTER, mainPanel);

    checkboxList = new ArrayList<>();
    for (int i = 0; i < 256; i++) {  // 16 instruments * 16 beats
      JCheckBox c = new JCheckBox();
      c.setSelected(false);
      checkboxList.add(c);
      mainPanel.add(c);
    }

    setUpMidi(); // Initialize MIDI sequencer and sequence

    frame.setBounds(50, 50, 300, 300);
    frame.pack();
    frame.setVisible(true);
  }

  private void setUpMidi() {
    try {
      sequencer = MidiSystem.getSequencer();
      sequencer.open();
      sequence = new Sequence(Sequence.PPQ, 4); // Create sequence with timing resolution
      track = sequence.createTrack();
      sequencer.setTempoInBPM(120);             // Default tempo

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Build the MIDI track based on checkbox selections and start playback
  private void buildTrackAndStart() {
    int[] trackList;

    sequence.deleteTrack(track);        // Clear old track
    track = sequence.createTrack();     // Create new track

    for (int i = 0; i < 16; i++) {     // For each instrument (row)
      trackList = new int[16];          // Array representing 16 beats for this instrument

      int key = instruments[i];         // MIDI key for the instrument

      for (int j = 0; j < 16; j++) {   // For each beat (column)
        JCheckBox jc = checkboxList.get(j + 16 * i); // Get checkbox at row i, column j
        if (jc.isSelected()) {
          trackList[j] = key;           // If checked, set the instrument key for this beat
        } else {
          trackList[j] = 0;             // Otherwise, silence
        }
      }

      makeTracks(trackList);            // Add events for this instrument to track
      track.add(makeEvent(CONTROL_CHANGE, 1, 127, 0, 16)); // Control event at tick 16
    }

    track.add(makeEvent(PROGRAM_CHANGE, 9, 1, 0, 15)); // Program change event

    try {
      sequencer.setSequence(sequence);          // Load the sequence into sequencer
      sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY); // Loop indefinitely
      sequencer.setTempoInBPM(120);              // Set tempo to 120 BPM
      sequencer.start();                         // Start playback
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Adjust the sequencer tempo by a given multiplier
  private void changeTempo(float tempoMultiplier) {
    float tempoFactor = sequencer.getTempoFactor();
    sequencer.setTempoFactor(tempoFactor * tempoMultiplier);
  }

  // Add NOTE_ON and NOTE_OFF MIDI events to the track for each beat in the list
  private void makeTracks(int[] list) {
    for (int i = 0; i < 16; i++) {
      int key = list[i];

      if (key != 0) {
        // Start note at tick i
        track.add(makeEvent(NOTE_ON, 9, key, 100, i));
        // Stop note at tick i+1
        track.add(makeEvent(NOTE_OFF, 9, key, 100, i + 1));
      }
    }
  }

  // Helper method to create a MIDI event with given parameters
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
