package ch15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// This program creates a simple Swing GUI with a text area inside a scroll pane and a button that appends text when clicked.

public class TextArea1 {
  public static void main(String[] args) {
    TextArea1 gui = new TextArea1();              // Create an instance of the GUI
    gui.go();                                     // Call the method to build and display the GUI
  }

  public void go() {
    JFrame frame = new JFrame();                  // Create the main application window
    JPanel panel = new JPanel();                  // Create a panel to hold the scrollable text area

    JButton button = new JButton("Just Click It"); // Create a button labeled "Just Click It"

    JTextArea text = new JTextArea(10, 20);       // Create a text area with 10 rows and 20 columns
    text.setLineWrap(true);                       // Enable line wrapping for the text area
    button.addActionListener(e -> text.append("button clicked \n")); // Add action to append text when button is clicked

    JScrollPane scroller = new JScrollPane(text); // Wrap the text area in a scroll pane
    scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // Always show vertical scroll bar
    scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // Never show horizontal scroll bar

    panel.add(scroller);                          // Add the scroll pane (with text area) to the panel

    frame.getContentPane().add(BorderLayout.CENTER, panel);  // Add panel to center of frame
    frame.getContentPane().add(BorderLayout.SOUTH, button);  // Add button to bottom of frame

    frame.setSize(350, 300);                      // Set the window size
    frame.setVisible(true);                       // Make the window visible
  }
}
