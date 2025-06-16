package ch15;

import javax.swing.*;
import java.awt.*;

// This code creates a Swing GUI with a menu bar at the top and a horizontal box in the center containing a button and a checkbox.

public class SwingExamples {
  public static void main(String[] args) {
    JFrame frame = new JFrame();                            // Create main application window
    JButton button = new JButton("click me");               // Create a button
    JCheckBox checkBox = new JCheckBox("choose me");        // Create a checkbox

    JMenuBar menuBar = new JMenuBar();                      // Create a menu bar
    menuBar.add(new JMenu("File"));                         // Add "File" menu
    menuBar.add(new JMenu("Panic"));                        // Add "Panic" menu
    menuBar.add(new JMenu("Deviate"));                      // Add "Deviate" menu
    frame.add(BorderLayout.NORTH, menuBar);                 // Place menu bar at the top of the frame

    Box textBox = new Box(BoxLayout.X_AXIS);                // Create a horizontal box layout
    textBox.add(button);                                    // Add button to the box
    textBox.add(checkBox);                                  // Add checkbox to the box
    frame.getContentPane().add(BorderLayout.CENTER, textBox); // Add the box to the center of the frame

    frame.setSize(300, 300);                                // Set window size
    frame.setVisible(true);                                 // Make the window visible
  }
}
