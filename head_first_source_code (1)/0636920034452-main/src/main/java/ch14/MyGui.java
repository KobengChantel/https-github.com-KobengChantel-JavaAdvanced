package ch14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// This program creates a simple GUI with two buttons and a label where clicking one button changes the frame's background color randomly, and clicking the other changes the label's text.

class MyGui {
  private JFrame frame;
  private JLabel label;
  private JButton colorButton;
  private JButton labelButton;

  void gui() {
    frame = new JFrame("My GUI");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());

    // Create label and buttons
    label = new JLabel("I'm a label");
    colorButton = new JButton("Change Color");
    labelButton = new JButton("Change Label");

    // Instantiate listeners and register them with the buttons
    ColorButtonListener cListener = new ColorButtonListener(frame);
    LabelButtonListener lListener = new LabelButtonListener(label);

    colorButton.addActionListener(cListener);
    labelButton.addActionListener(lListener);

    // Add components to frame
    frame.add(colorButton);
    frame.add(labelButton);
    frame.add(label);

    frame.setSize(300, 100);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    MyGui gui = new MyGui();
    gui.gui();
  }
}

// Listener to repaint the frame with a new random background color when the color button is clicked
class ColorButtonListener implements ActionListener {
  private JFrame frame;
  private java.util.Random random = new java.util.Random();

  ColorButtonListener(JFrame frame) {
    this.frame = frame;
  }

  public void actionPerformed(ActionEvent event) {
    // Change the frame background to a random color
    int r = random.nextInt(256);
    int g = random.nextInt(256);
    int b = random.nextInt(256);
    frame.getContentPane().setBackground(new Color(r, g, b));
    frame.repaint();
  }
}

// Listener to change the label text when the label button is clicked
class LabelButtonListener implements ActionListener {
  private JLabel label;

  LabelButtonListener(JLabel label) {
    this.label = label;
  }

  public void actionPerformed(ActionEvent event) {
    label.setText("That hurt!");
  }
}
