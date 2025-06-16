package ch14;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

// This program creates a simple animation where a green circle moves diagonally across a white JPanel.

public class SimpleAnimation {
  private int xPos = 70;  // Initial horizontal position of the oval
  private int yPos = 70;  // Initial vertical position of the oval

  public static void main(String[] args) {
    SimpleAnimation gui = new SimpleAnimation(); // Create instance of animation class
    gui.go();                                   // Start the animation
  }

  public void go() {
    JFrame frame = new JFrame();                 // Create window frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close

    MyDrawPanel drawPanel = new MyDrawPanel();  // Create custom drawing panel

    frame.getContentPane().add(drawPanel);      // Add panel to the frame
    frame.setSize(300, 300);                     // Set window size
    frame.setVisible(true);                      // Show the window

    // Animation loop: move the oval diagonally by increasing xPos and yPos gradually
    for (int i = 0; i < 130; i++) {
      xPos++;                                   // Move right
      yPos++;                                   // Move down

      drawPanel.repaint();                       // Request panel to repaint with new position

      try {
        TimeUnit.MILLISECONDS.sleep(50);        // Pause for 50 milliseconds between frames for smooth animation
      } catch (Exception e) {
        e.printStackTrace();                     // Print any errors during sleep
      }
    }
  }

  // Inner class to define custom drawing behavior
  class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
      super.paintComponent(g);                   // Clear previous drawings properly

      g.setColor(Color.white);                    // Set background color to white
      g.fillRect(0, 0, this.getWidth(), this.getHeight()); // Fill entire panel with white

      g.setColor(Color.green);                    // Set drawing color to green
      g.fillOval(xPos, yPos, 40, 40);             // Draw filled oval at current position with size 40x40
    }
  }
}
