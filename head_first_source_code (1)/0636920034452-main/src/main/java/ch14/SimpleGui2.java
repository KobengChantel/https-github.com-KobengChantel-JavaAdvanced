package ch14;

import javax.swing.*;
import java.awt.event.*;

// This program creates a simple GUI with a button that changes its label text when clicked.

public class SimpleGui2 implements ActionListener {
  private JButton button;  // Button instance variable to modify on click

  public static void main(String[] args) {
    SimpleGui2 gui = new SimpleGui2(); // Create instance of the GUI
    gui.go();                         // Initialize and display the GUI
  }

  public void go() {
    JFrame frame = new JFrame();            // Create window frame
    button = new JButton("click me");      // Create button with initial label
    button.addActionListener(this);        // Register this class as the button's event listener

    frame.getContentPane().add(button);    // Add button to frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit program on close
    frame.setSize(300, 300);                // Set window size
    frame.setVisible(true);                 // Make window visible
  }

  // This method is called when the button is clicked
  public void actionPerformed(ActionEvent event) {
    button.setText("I've been clicked!");  // Change button's label text on click
  }
}
