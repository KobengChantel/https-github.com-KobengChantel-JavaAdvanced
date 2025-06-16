package ch15;

import javax.swing.*;
import java.awt.*;

// This program creates a simple Swing GUI with a label and a text field to input a dog's first name.

public class TextFieldExample {

  public static void main(String[] args) {
    TextFieldExample gui = new TextFieldExample(); // Create an instance of the GUI class
    gui.go();                                      // Launch the GUI
  }

  public void go() {
    JFrame frame = new JFrame();                   // Create the main application window
    JPanel panel = new JPanel();                   // Create a panel to hold components

    JTextField textField = new JTextField(20);     // Create a text field with 20 columns
    JLabel label = new JLabel("Dog's first name:"); // Create a label for the text field
    panel.add(label);                              // Add label to panel
    panel.add(textField);                          // Add text field to panel

    frame.getContentPane().add(BorderLayout.NORTH, panel); // Add the panel to the top of the window
    frame.setSize(400,200);                        // Set window size
    frame.setVisible(true);                        // Make the window visible
  }
}
