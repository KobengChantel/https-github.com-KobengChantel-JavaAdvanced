package ch15.ex;

import javax.swing.*;

// This program creates a JFrame using the 'missing' layout fragment from the Fragments class and displays it.

public class TestLayout {
  public static void main(String[] args) {
    new TestLayout().go();  // Create instance and run the GUI
  }

  public void go() {
    JFrame frame = Fragments.missing();  // Get a JFrame configured by the 'missing' method in Fragments

    frame.setSize(300, 300);              // Set window size
    frame.setVisible(true);               // Make window visible
  }
}
