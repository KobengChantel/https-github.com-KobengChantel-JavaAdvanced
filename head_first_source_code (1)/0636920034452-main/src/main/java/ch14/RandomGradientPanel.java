package ch14;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

// This program creates a JPanel that draws an oval filled with a randomly generated color gradient each time it repaints.

public class RandomGradientPanel extends JPanel {
  // Override paintComponent to draw a gradient-filled oval
  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;  // Cast Graphics to Graphics2D for advanced drawing

    Random random = new Random();      // Random number generator

    // Generate random RGB values for the gradient's start color
    int red = random.nextInt(256);
    int green = random.nextInt(256);
    int blue = random.nextInt(256);
    Color startColor = new Color(red, green, blue);

    // Generate random RGB values for the gradient's end color
    red = random.nextInt(256);
    green = random.nextInt(256);
    blue = random.nextInt(256);
    Color endColor = new Color(red, green, blue);

    // Create a gradient paint from (70,70) to (150,150) using the two random colors
    GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);

    g2d.setPaint(gradient);           // Set the paint of the Graphics2D object to the gradient
    g2d.fillOval(70, 70, 100, 100);   // Fill an oval with the gradient at (70,70) with width and height 100
  }

  // Main method to create the window and show the panel
  public static void main(String[] args) {
    JFrame frame = new JFrame();               // Create window frame
    frame.add(new RandomGradientPanel());     // Add our custom panel
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close
    frame.setSize(300, 300);                   // Set window size
    frame.setVisible(true);                    // Make window visible
  }
}
