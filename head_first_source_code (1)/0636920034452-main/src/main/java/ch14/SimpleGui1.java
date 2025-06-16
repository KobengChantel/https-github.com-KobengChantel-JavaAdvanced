package ch14;

import javax.swing.*;

// This program creates a simple GUI window with a button labeled "click me".

public class SimpleGui1 {
  public static void main(String[] args) {
    JFrame frame = new JFrame();                  // Create a new window frame
    JButton button = new JButton("click me");    // Create a button with label "click me"

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit program when window closes

    frame.getContentPane().add(button);          // Add the button to the frame's content pane

    frame.setSize(300, 300);                      // Set window size to 300x300 pixels

    frame.setVisible(true);                       // Make the window visible
  }
}
