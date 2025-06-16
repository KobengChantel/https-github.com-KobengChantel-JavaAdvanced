package ch15;

import javax.swing.*;
import java.awt.*;

// This program creates a GUI with a dark gray vertical panel on the right side containing two buttons labeled "shock me" and "bliss".

public class Panel1 {

  public static void main(String[] args) {
    Panel1 gui = new Panel1();
    gui.go();
  }

  public void go() {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    panel.setBackground(Color.darkGray);                    // Set panel background to dark gray

    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Arrange components vertically

    JButton button = new JButton("shock me");
    JButton buttonTwo = new JButton("bliss");

    panel.add(button);
    panel.add(buttonTwo);

    frame.getContentPane().add(BorderLayout.EAST, panel);    // Add panel to the right side of frame
    frame.setSize(250,200);
    frame.setVisible(true);
  }

}
