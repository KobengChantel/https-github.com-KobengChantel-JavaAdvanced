package ch15.ex;

import javax.swing.*;
import java.awt.*;

// This class defines several static methods, each creating and returning a JFrame with different
// layouts and component arrangements using buttons and a dark gray panel.

public class Fragments {

  // Creates a JFrame with a dark gray panel containing "watari" button at the top (NORTH),
  // and a "tesuji" button centered (CENTER).
  static JFrame fragmentD() {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    panel.setBackground(Color.darkGray);
    JButton button = new JButton("tesuji");
    JButton buttonTwo = new JButton("watari");
    frame.getContentPane().add(BorderLayout.NORTH, panel);
    panel.add(buttonTwo);
    frame.getContentPane().add(BorderLayout.CENTER, button);
    return frame;
  }

  // Creates a JFrame with a dark gray panel containing "watari" button on the right (EAST),
  // and a "tesuji" button centered (CENTER).
  static JFrame fragmentB() {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    panel.setBackground(Color.darkGray);
    JButton button = new JButton("tesuji");
    JButton buttonTwo = new JButton("watari");
    panel.add(buttonTwo);
    frame.getContentPane().add(BorderLayout.CENTER, button);
    frame.getContentPane().add(BorderLayout.EAST, panel);
    return frame;
  }

  // Creates a JFrame with only a centered "tesuji" button.
  static JFrame fragmentC() {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    panel.setBackground(Color.darkGray);
    JButton button = new JButton("tesuji");
    JButton buttonTwo = new JButton("watari");
    panel.add(buttonTwo); // Although buttonTwo is added to panel, panel itself is not added to frame
    frame.getContentPane().add(BorderLayout.CENTER, button);
    return frame;
  }

  // Creates a JFrame with "watari" button at the top (NORTH), and a dark gray panel containing "tesuji" button on the right (EAST).
  static JFrame fragmentA() {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    panel.setBackground(Color.darkGray);
    JButton button = new JButton("tesuji");
    JButton buttonTwo = new JButton("watari");
    panel.add(button);
    frame.getContentPane().add(BorderLayout.NORTH, buttonTwo);
    frame.getContentPane().add(BorderLayout.EAST, panel);
    return frame;
  }

  // Creates a JFrame with a dark gray panel containing "watari" button at the bottom (SOUTH),
  // and "tesuji" button at the top (NORTH).
  static JFrame fragmentE() {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    panel.setBackground(Color.darkGray);
    JButton button = new JButton("tesuji");
    JButton buttonTwo = new JButton("watari");
    frame.getContentPane().add(BorderLayout.SOUTH, panel);
    panel.add(buttonTwo);
    frame.getContentPane().add(BorderLayout.NORTH, button);
    return frame;
  }

  // Creates a JFrame with "tesuji" button at the bottom (SOUTH),
  // and a dark gray panel containing "watari" button in the center (CENTER).
  static JFrame missing() {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    panel.setBackground(Color.darkGray);
    JButton button = new JButton("tesuji");
    JButton buttonTwo = new JButton("watari");
    frame.getContentPane().add(BorderLayout.SOUTH, button);
    panel.add(buttonTwo);
    frame.getContentPane().add(BorderLayout.CENTER, panel);
    return frame;
  }

}
