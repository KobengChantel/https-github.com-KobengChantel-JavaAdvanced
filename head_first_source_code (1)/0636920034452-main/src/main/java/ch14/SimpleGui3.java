package ch14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// This program creates a GUI with a button that, when clicked, repaints the window to change the colors of the drawing.

public class SimpleGui3 implements ActionListener {
  private JFrame frame;  // Reference to the main window frame

  public static void main(String[] args) {
    SimpleGui3 gui = new SimpleGui3(); // Create instance of the GUI
    gui.go();                         // Initialize and display the GUI
  }

  public void go() {
    frame = new JFrame();                   // Create the window frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit program when window closes

    JButton button = new JButton("Change colors"); // Create button labeled "Change colors"
    button.addActionListener(this);                 // Register action listener for button clicks

    MyDrawPanel drawPanel = new MyDrawPanel();      // Create a custom drawing panel

    frame.getContentPane().add(BorderLayout.SOUTH, button);   // Add button to bottom of frame
    frame.getContentPane().add(BorderLayout.CENTER, drawPanel); // Add drawing panel to center
    frame.setSize(300, 300);                           // Set window size
    frame.setVisible(true);                            // Make window visible
  }

  // When the button is clicked, repaint the frame (which will trigger drawing updates)
  public void actionPerformed(ActionEvent event) {
    frame.repaint();
  }

  // Inner class for custom drawing panel (likely paints something with colors, not shown here)
  class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      // Drawing code goes here, typically changing colors when repaint is triggered
      // Since code is missing, this is a placeholder
    }
  }
}
