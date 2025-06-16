package ch14.btc;  // Declares this class is part of the ch14.btc package

import javax.swing.*;            // For GUI components like JFrame and JButton
import java.awt.*;              // For layout management (e.g., BorderLayout)
import java.awt.event.*;        // For handling events like button clicks

// This program creates a simple Swing GUI with a button that toggles its label between "A" and "B" when clicked.

class InnerButton {
  private JButton button;       // Button that will be displayed in the GUI

  public static void main(String[] args) {
    InnerButton gui = new InnerButton();  // Create an instance of InnerButton
    gui.go();                             // Launch the GUI
  }

  public void go() {
    JFrame frame = new JFrame();                        // Create a window (frame)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit the program when window closes

    button = new JButton("A");                          // Initialize button with label "A"
    button.addActionListener(new ButtonListener());     // Register action listener for button

    frame.getContentPane().add(BorderLayout.SOUTH, button);  // Add button to bottom of frame
    frame.setSize(200, 100);                            // Set window size
    frame.setVisible(true);                             // Make window visible
  }

  // Inner class that defines what happens when the button is clicked
  class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (button.getText().equals("A")) {
        button.setText("B");     // If label is "A", change to "B"
      } else {
        button.setText("A");     // Otherwise, change back to "A"
      }
    }
  }
}
