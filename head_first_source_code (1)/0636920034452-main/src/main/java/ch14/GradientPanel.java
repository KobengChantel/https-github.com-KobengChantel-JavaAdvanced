package ch14;

import javax.swing.*;
import java.awt.*;

// This program creates a window displaying a circle filled with a blue-to-orange gradient using a custom JPanel.

public class GradientPanel extends JPanel {
  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;  // Cast Graphics to Graphics2D for advanced drawing features

    // Create a GradientPaint object transitioning from blue at (70,70) to orange at (150,150)
    GradientPaint gradient = new GradientPaint(70, 70, Color.blue, 150, 150, Color.orange);

    g2d.setPaint(gradient);            // Set the paint of Graphics2D to the gradient
    g2d.fillOval(70, 70, 100, 100);   // Draw a filled oval (circle) with the gradient at position (70,70) sized 100x100
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();            // Create a new window
    frame.add(new GradientPanel());         // Add the GradientPanel to the window
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close program on window close
    frame.setSize(300, 300);                 // Set window size
    frame.setVisible(true);                  // Make window visible
  }
}
