package ch15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// This program creates a simple GUI with a checkbox that prints its state ("on" or "off") to the console when toggled.

public class CheckboxExample {

  private JCheckBox check;

  public static void main(String[] args) {
    CheckboxExample gui = new CheckboxExample();
    gui.go();
  }

  public void go() {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    check = new JCheckBox("Goes to 11");
    panel.add(check);

    frame.getContentPane().add(BorderLayout.NORTH, panel);
    frame.setSize(200, 200);
    frame.setVisible(true);
  }

  public void itemStateChanged(ItemEvent e) {
    String onOrOff = "off";
    if (check.isSelected()) {
      onOrOff = "on";
    }
    System.out.println("Check box is " + onOrOff);
  }
}
