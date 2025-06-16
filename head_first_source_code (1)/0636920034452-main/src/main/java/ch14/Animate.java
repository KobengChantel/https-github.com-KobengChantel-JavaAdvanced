package ch14;  // Declares this class is part of the ch14 package

import javax.swing.*;             // For GUI components like JFrame and JPanel
import java.awt.*;                // For graphics drawing (e.g., Color, Graphics)
import java.util.concurrent.TimeUnit;  // For sleep/delay functionality

// This program creates a simple animation that repeatedly redraws a shrinking blue rectangle on a white background.

public class Animate {
  int x = 1;  // X-coordinate and width modifier for the rectangle
  int y = 1;  // Y-coordinate and height modifier for the rectangle

  public static void main(String[] args) {
    Animate gui = new Animate();  // Create instance of Animate class
    gui.go();                     // Launch the animation
  }

  public void go() {
    JFrame frame = new JFrame();                          // Create a window
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close

    MyDrawP drawP = new MyDrawP();                        // Create drawing panel
    frame.getContentPane().add(drawP);                    // Add panel to frame
    frame.setSize(500, 270);                              // Set window size
    frame.setVisible(true);                               // Show the window

    // Animate by updating x and y repeatedly
    for (int i = 0; i < 124; i++, y++, x++) {
      x++;                        // Increase x even more to shrink faster
      drawP.repaint();            // Redraw the panel with updated values

      try {
        TimeUnit.MILLISECONDS.sleep(50); // Pause for 50 milliseconds
      } catch (Exception ex) {
        // Ignore any interruptions
      }
    }
  }

  // Inner class that handles custom drawing
  class MyDrawP extends JPanel {
    public void paintComponent(Graphics g) {
      g.setColor(Color.white);                     // Set background color
      g.fillRect(0, 0, 500, 250);                  // Fill background

      g.setColor(Color.blue);                      // Set shape color
      g.fillRect(x, y, 500 - x * 2, 250 - y * 2);  // Draw shrinking blue rectangle
    }
  }
}
