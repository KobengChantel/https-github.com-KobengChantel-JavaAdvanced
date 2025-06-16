package ch14;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

// This program creates a JPanel that paints a randomly colored oval on a black background every time it repaints.

public class RandomColorPanel extends JPanel {
  // Override paintComponent to customize drawing on the panel
  public void paintComponent(Graphics g) {
    super.paintComponent(g); // Clear the panel properly before drawing

    g.fillRect(0, 0, this.getWidth(), this.getHeight()); // Fill the entire panel with the default color (black)

    Random random = new Random();                // Create a random number generator
    int red = random.nextInt(256);               // Generate random red value (0-255)
    int green = random.nextInt(256);             // Generate random green value (0-255)
    int blue = random.nextInt(256);              // Generate random blue value (0-255)

    Color randomColor = new Color(red, green, blue); // Create a new color from random RGB values
    g.setColor(randomColor);                     // Set the current drawing color to the random color
    g.fillOval(70, 70, 100, 100);                // Draw a filled oval at position (70,70) with width and height 100
  }

  // Main method to create a window and display the panel
  public static void main(String[] args) {
    JFrame frame = new JFrame();                  // Create a new window frame
    frame.add(new RandomColorPanel());            // Add an instance of RandomColorPanel to the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the program when window closes
    frame.setSize(300, 300);                      // Set the size of the window to 300x300 pixels
    frame.setVisible(true);                       // Make the window visible on screen
  }
}
