package ch16;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

import static javax.sound.midi.ShortMessage.*;

// This program creates a graphical drum machine using checkboxes, MIDI events, and Java serialization to save/restore beat patterns.

public class BeatBox {
  private ArrayList<JCheckBox> checkboxList;  // Stores the state of 16x16 beat checkboxes
  private Sequencer sequencer;               // Plays MIDI sequence
  private Sequence sequence;                 // MIDI sequence
  private Track track;                       // MIDI track in the sequence

  // Names of instruments shown on the GUI
  String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap",
          "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap",
          "Low-mid Tom", "High Agogo", "Open Hi Conga"};
  // Corresponding MIDI key codes for each instrument
  int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

  public static void main(String[] args) {
    new BeatBox().buildGUI();  // Launch the GUI
  }

  public void buildGUI() {
    // Set up main frame and layout
    JFrame frame = new JFrame("Cyber BeatBox");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    BorderLayout layout = new BorderLayout();
    JPanel background = new JPanel(layout);
    background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    // Create buttons and add to a vertical box
    Box buttonBox = new Box(BoxLayout.Y_AXIS);

    JButton start = new JButton("Start");
    start.addActionListener(e -> buildTrackAndStart());  // Start playing the beat
    buttonBox.add(start);

    JButton stop = new JButton("Stop");
    stop.addActionListener(e -> sequencer.stop());       // Stop the sequencer
    buttonBox.add(stop);

    JButton upTempo = new JButton("Tempo Up");
    upTempo.addActionListener(e -> changeTempo(1.03f));  // Increase tempo
    buttonBox.add(upTempo);

    JButton downTempo = new JButton("Tempo Down");
    downTempo.addActionListener(e -> changeTempo(0.97f)); // Decrease tempo
    buttonBox.add(downTempo);

    JButton save = new JButton("serializeIt");
    save.addActionListener(e -> writeFile());            // Save checkbox state
    buttonBox.add(save);

    JButton restore = new JButton("restore");
    restore.addActionListener(e -> readFile());          // Load checkbox state
    buttonBox.add(restore);

    // Create labels for each instrument name
    Box nameBox = new Box(BoxLayout.Y_AXIS);
    for (String instrumentName : instrumentNames) {
      JLabel instrumentLabel = new JLabel(instrumentName);
      instrumentLabel.setBorder(BorderFactory.createEmptyBorder(4, 1, 4, 1));
      nameBox.add(instrumentLabel);
    }

    // Add control components to frame
    background.add(BorderLayout.EAST, buttonBox);
    background.add(BorderLayout.WEST, nameBox);
    frame.getContentPane().add(background);

    // Create main grid of checkboxes (16x16)
    GridLayout grid = new GridLayout(16, 16);
    grid.setVgap(1);
    grid.setHgap(2);
    JPanel mainPanel = new JPanel(grid);
    background.add(BorderLayout.CENTER, mainPanel);

    checkboxList = new ArrayList<>();
    for (int i = 0; i < 256; i++) {
      JCheckBox c = new JCheckBox();
      c.setSelected(false);
      checkboxList.add(c);
      mainPanel.add(c);
    }

    setUpMidi();  // Initialize MIDI sequencer

    frame.setBounds(50, 50, 300, 300);
    frame.pack(); // Adjust to components
    frame.setVisible(true);
  }

  private void setUpMidi() {
    try {
      sequencer = MidiSystem.getSequencer();  // Get default sequencer
      sequencer.open();                       // Open it
      sequence = new Sequence(Sequence.PPQ, 4); // PPQ = pulses per quarter note
      track = sequence.createTrack();         // Create a new track
      sequencer.setTempoInBPM(120);           // Set initial tempo
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void buildTrackAndStart() {
    int[] trackList;

    sequence.deleteTrack(track);              // Remove old track
    track = sequence.createTrack();           // Start a new one

    for (int i = 0; i < 16; i++) {
      trackList = new int[16];
      int key = instruments[i];               // Get instrument's MIDI key

      for (int j = 0; j < 16; j++) {
        JCheckBox jc = checkboxList.get(j + 16 * i);
        trackList[j] = jc.isSelected() ? key : 0; // 0 = no note
      }

      makeTracks(trackList); // Add to track
      track.add(makeEvent(CONTROL_CHANGE, 1, 127, 0, 16)); // Optional MIDI controller event
    }

    track.add(makeEvent(PROGRAM_CHANGE, 9, 1, 0, 15)); // Optional program change

    try {
      sequencer.setSequence(sequence);
      sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
      sequencer.setTempoInBPM(120);
      sequencer.start(); // Play the track
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void changeTempo(float tempoMultiplier) {
    float tempoFactor = sequencer.getTempoFactor();
    sequencer.setTempoFactor(tempoFactor * tempoMultiplier); // Multiply to speed up/slow down
  }

  private void makeTracks(int[] list) {
    for (int i = 0; i < 16; i++) {
      int key = list[i];
      if (key != 0) {
        track.add(makeEvent(NOTE_ON, 9, key, 100, i));   // Note on
        track.add(makeEvent(NOTE_OFF, 9, key, 100, i+1));// Note off
      }
    }
  }

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

  private void writeFile() {
    boolean[] checkboxState = new boolean[256];
    for (int i = 0; i < 256; i++) {
      JCheckBox check = checkboxList.get(i);
      checkboxState[i] = check.isSelected(); // Save state
    }

    try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Checkbox.ser"))) {
      os.writeObject(checkboxState); // Serialize state to file
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void readFile() {
    boolean[] checkboxState = null;
    try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("Checkbox.ser"))) {
      checkboxState = (boolean[]) is.readObject(); // Deserialize
    } catch (Exception e) {
      e.printStackTrace();
    }

    for (int i = 0; i < 256; i++) {
      JCheckBox check = checkboxList.get(i);
      check.setSelected(checkboxState[i]); // Restore state
    }

    sequencer.stop();         // Stop current sequence
    buildTrackAndStart();     // Start new one with restored state
  }
}
