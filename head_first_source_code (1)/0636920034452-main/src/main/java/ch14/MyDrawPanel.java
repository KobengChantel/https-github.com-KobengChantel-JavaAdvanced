package ch14;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

// This program creates a window that displays a circle with a random color each time it is painted.

class MyDrawPanel extends JPanel {

  public void paintComponent(Graphics g) {
    super.paintComponent(g); // Clear the panel before drawing

    // Fill the entire panel background (default color is black since no color set before)
    g.fillRect(0, 0, this.getWidth(), this.getHeight());

    Random random = new Random();
    int red = random.nextInt(256);
    int green = random.nextInt(256);
    int blue = random.nextInt(256);

    Color randomColor = new Color(red, green, blue);
    g.setColor(randomColor);               // Set the graphics color to the random color
    g.fillOval(70, 70, 100, 100);          // Draw a filled oval at position (70,70) with width and height 100
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new MyDrawPanel());
    frame.setSize(300, 300);
    frame.setVisible(true);
  }
}
