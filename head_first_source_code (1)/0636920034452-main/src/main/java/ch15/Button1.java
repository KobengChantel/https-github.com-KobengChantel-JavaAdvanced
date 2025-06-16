package ch15;

import javax.swing.*;
import java.awt.*;

// This program creates a simple GUI with five buttons arranged using BorderLayout in the positions East, West, North, South, and Center.

public class Button1 {
  public static void main(String[] args) {
    Button1 gui = new Button1();
    gui.go();
  }

  public void go() {
    JFrame frame = new JFrame();

    JButton east = new JButton("East");
    JButton west = new JButton("West");
    JButton north = new JButton("North");
    JButton south = new JButton("South");
    JButton center = new JButton("Center");

    // Add buttons to the frame's content pane at specified BorderLayout positions
    frame.getContentPane().add(BorderLayout.EAST, east);
    frame.getContentPane().add(BorderLayout.WEST, west);
    frame.getContentPane().add(BorderLayout.NORTH, north);
    frame.getContentPane().add(BorderLayout.SOUTH, south);
    frame.getContentPane().add(BorderLayout.CENTER, center);

    frame.setSize(300, 300);     // Set window size
    frame.setVisible(true);      // Make the window visible
  }
}
