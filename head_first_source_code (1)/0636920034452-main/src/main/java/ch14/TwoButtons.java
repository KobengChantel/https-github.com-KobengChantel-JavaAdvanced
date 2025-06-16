package ch14;

import javax.swing.*;
import java.awt.*;

// This program creates a GUI with two buttons: one changes a label's text, the other repaints a drawing panel with a circle.

public class TwoButtons {
  private JFrame frame;   // Main window frame
  private JLabel label;   // Label whose text can be changed

  public static void main(String[] args) {
    TwoButtons gui = new TwoButtons(); // Create instance of GUI
    gui.go();                         // Initialize and display GUI
  }

  public void go() {
    frame = new JFrame();                       // Create window frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close

    JButton labelButton = new JButton("Change Label");   // Button to change label text
    labelButton.addActionListener(event -> label.setText("Ouch!")); // Set label text on click

    JButton colorButton = new JButton("Change Circle");  // Button to repaint the circle
    colorButton.addActionListener(event -> frame.repaint());       // Repaint the frame on click

    label = new JLabel("I’m a label");            // Initialize label with default text
    MyDrawPanel drawPanel = new MyDrawPanel();    // Custom panel to draw a circle (implementation assumed)

    frame.getContentPane().add(BorderLayout.SOUTH, colorButton); // Add color button at bottom
    frame.getContentPane().add(BorderLayout.CENTER, drawPanel);  // Add drawing panel in center
    frame.getContentPane().add(BorderLayout.EAST, labelButton);  // Add label button to right side
    frame.getContentPane().add(BorderLayout.WEST, label);        // Add label to left side

    frame.setSize(500, 400);                      // Set window size
    frame.setVisible(true);                       // Make window visible
  }
}
