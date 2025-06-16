package ch14;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.sound.midi.ShortMessage.*;

// This program creates a GUI window that displays colorful random rectangles synchronized with MIDI notes played by a sequencer.

public class MiniMusicPlayer3 {
  private MyDrawPanel panel;
  private Random random = new Random();

  public static void main(String[] args) {
    MiniMusicPlayer3 mini = new MiniMusicPlayer3();
    mini.go();
  }

  // Set up the GUI frame and add the custom drawing panel that listens to MIDI controller events
  public void setUpGui() {
    JFrame frame = new JFrame("My First Music Video");
    panel = new MyDrawPanel();
    frame.setContentPane(panel);
    frame.setBounds(30, 30, 300, 300);
    frame.setVisible(true);
  }

  // Prepare MIDI sequencer, sequence, and track, add random notes with controller events that trigger visual changes
  public void go() {
    setUpGui();

    try {
      Sequencer sequencer = MidiSystem.getSequencer();
      sequencer.open();

      // Register the panel as a listener for controller event 127, to trigger visual updates
      sequencer.addControllerEventListener(panel, new int[]{127});

      Sequence seq = new Sequence(Sequence.PPQ, 4);
      Track track = seq.createTrack();

      int note;
      for (int i = 0; i < 60; i += 4) {
        note = random.nextInt(50) + 1;                      // Random note between 1 and 50
        track.add(makeEvent(NOTE_ON, 1, note, 100, i));     // Note ON event
        track.add(makeEvent(CONTROL_CHANGE, 1, 127, 0, i)); // Controller event triggers visual update
        track.add(makeEvent(NOTE_OFF, 1, note, 100, i + 2));// Note OFF event
      }

      sequencer.setSequence(seq);
      sequencer.start();
      sequencer.setTempoInBPM(120);                         // Moderate tempo
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  // Helper method to create MIDI events
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

  // Inner class that draws rectangles in random colors and positions when a controller event is received
  class MyDrawPanel extends JPanel implements ControllerEventListener {
    private boolean msg = false;

    // Called when controller event 127 is received, sets flag and requests repaint
    public void controlChange(ShortMessage event) {
      msg = true;
      repaint();
    }

    // Paints a rectangle with random size, position, and color if the flag is set
    public void paintComponent(Graphics g) {
      super.paintComponent(g); // Good practice to call super method first
      if (msg) {
        int r = random.nextInt(250);
        int gr = random.nextInt(250);
        int b = random.nextInt(250);

        g.setColor(new Color(r, gr, b));

        int height = random.nextInt(120) + 10;
        int width = random.nextInt(120) + 10;

        int xPos = random.nextInt(40) + 10;
        int yPos = random.nextInt(40) + 10;

        g.fillRect(xPos, yPos, width, height);
        msg = false;
      }
    }
  }
}
