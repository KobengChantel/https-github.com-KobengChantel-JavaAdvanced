package AppendixA;
// chapter 14

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.io.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;
import java.net.*;

// This code implements a collaborative beat-making application using
// Java Swing and MIDI, allowing users to create, play, and share
// rhythm patterns over a network.

public class BeatBoxFinal {  // implements MetaEventListener

    JPanel mainPanel;
    JList incomingList;
    JTextField userMessage;
    ArrayList<JCheckBox> checkboxList;
    int nextNum;
    ObjectInputStream in;
    ObjectOutputStream out;
    Vector<String> listVector = new Vector<String>();
    String userName ;
    HashMap<String, boolean[]> otherSeqsMap = new HashMap<String, boolean[]>();
    Sequencer sequencer;
    Sequence sequence;
    Sequence mySequence = null;
    Track track;
    JFrame theFrame;

    // Instrument names and corresponding MIDI note values
    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat",
            "Open Hi-Hat","Acoustic Snare", "Crash Cymbal", "Hand Clap",
            "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga",
            "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo",
            "Open Hi Conga"};
    int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};


    public static void main (String[] args) {
        // Starts the application with the provided username
        new BeatBoxFinal().startUp(args[0]);
    }

    public void startUp(String name) {
        // Initializes networking and MIDI setup
        userName = name;
        try {
            Socket sock = new Socket("127.0.0.1", 4242);
            out = new ObjectOutputStream(sock.getOutputStream());
            in = new ObjectInputStream(sock.getInputStream());
            Thread remote = new Thread(new RemoteReader());
            remote.start();
        }
        catch (Exception ex) {
            System.out.println("couldn't connect - you'll have to play alone.");
        }
        setUpMidi();
        buildGUI();
    }

    public void buildGUI() {
        // Builds the GUI layout with buttons and 16x16 checkbox grid
        theFrame = new JFrame("Cyber BeatBox");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        checkboxList = new ArrayList<JCheckBox>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        // Add control buttons
        JButton start = new JButton("Start");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(new MyUpTempoListener());
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener(new MyDownTempoListener());
        buttonBox.add(downTempo);

        JButton sendIt = new JButton("sendIt");
        sendIt.addActionListener(new MySendListener());
        buttonBox.add(sendIt);

        JButton saveIt = new JButton("Serialize It");  // duplicate action
        saveIt.addActionListener(new MySendListener());
        buttonBox.add(saveIt);

        userMessage = new JTextField();  // input field for user message
        buttonBox.add(userMessage);

        // List of incoming beat sequences from other users
        incomingList = new JList();
        incomingList.addListSelectionListener(new MyListSelectionListener());
        incomingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane theList = new JScrollPane(incomingList);
        buttonBox.add(theList);
        incomingList.setListData(listVector);

        // List of instrument names
        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++) {
            nameBox.add(new Label(instrumentNames[i]));
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        theFrame.getContentPane().add(background);

        // 16x16 checkbox grid
        GridLayout grid = new GridLayout(16,16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);

        for (int i = 0; i < 256; i++) {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkboxList.add(c);
            mainPanel.add(c);
        }

        theFrame.setBounds(50,50,300,300);
        theFrame.pack();
        theFrame.setVisible(true);
    }

    public void setUpMidi() {
        // Set up MIDI sequencer
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ,4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);

        } catch(Exception e) {e.printStackTrace();}
    }

    public void buildTrackAndStart() {
        // Builds MIDI track based on checkbox states and starts playback
        ArrayList<Integer> trackList = null;
        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for (int i = 0; i < 16; i++){
            trackList = new ArrayList<Integer>();
            for (int j = 0; j < 16; j++){
                JCheckBox jc = checkboxList.get(j + (16 * i));
                if (jc.isSelected()){
                    int key = instruments[i];
                    trackList.add(key);
                } else {
                    trackList.add(null);
                }
            }
            makeTracks(trackList);
        }

        // Ensures sequence plays full 16 beats
        track.add(makeEvent(192,9,1,0,15));

        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch(Exception e) {e.printStackTrace();}
    }

    // =================== Inner class listeners ===================

    public class MyStartListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            buildTrackAndStart();
        }
    }

    public class MyStopListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            sequencer.stop();
        }
    }

    public class MyUpTempoListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor(tempoFactor * 1.03f);
        }
    }

    public class MyDownTempoListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor(tempoFactor * 0.97f);
        }
    }

    public class MySendListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            // Sends current checkbox states and message to server
            boolean[] checkboxState = new boolean[256];

            for (int i = 0; i < 256; i++) {
                JCheckBox check = checkboxList.get(i);
                checkboxState[i] = check.isSelected();
            }

            try {
                out.writeObject(userName + nextNum++ + ": " + userMessage.getText());
                out.writeObject(checkboxState);
            } catch(Exception ex) {
                ex.printStackTrace();
                System.out.println("sorry dude. Could not send it to the server");
            }
        }
    }

    public class MyListSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent le) {
            // Loads and plays a shared sequence from another user
            if (!le.getValueIsAdjusting()) {
                String selected = (String) incomingList.getSelectedValue();
                if (selected != null) {
                    boolean[] selectedState = otherSeqsMap.get(selected);
                    changeSequence(selectedState);
                    sequencer.stop();
                    buildTrackAndStart();
                }
            }
        }
    }

    public class RemoteReader implements Runnable {
        // Continuously listens for incoming sequences from server
        public void run() {
            try {
                Object obj;
                while ((obj = in.readObject()) != null) {
                    System.out.println("got an object from server");
                    System.out.println(obj.getClass());
                    String nameToShow = (String) obj;
                    boolean[] checkboxState = (boolean[]) in.readObject();
                    otherSeqsMap.put(nameToShow, checkboxState);
                    listVector.add(nameToShow);
                    incomingList.setListData(listVector);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // ===========================================================

    public void changeSequence(boolean[] checkboxState) {
        // Updates the checkboxes based on a stored sequence
        for (int i = 0; i < 256; i++) {
            checkboxList.get(i).setSelected(checkboxState[i]);
        }
    }

    public void makeTracks(ArrayList<Integer> list) {
        // Creates MIDI events for the given beat list
        for (int i = 0; i < 16; i++) {
            Integer num = list.get(i);
            if (num != null) {
                int numKey = num;
                track.add(makeEvent(144, 9, numKey, 100, i));
                track.add(makeEvent(128, 9, numKey, 100, i+1));
            }
        }
    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        // Helper method to create MIDI events
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return event;
    }
}
