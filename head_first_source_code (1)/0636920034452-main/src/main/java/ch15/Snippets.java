package ch15;

import javax.swing.*;

// This code creates two JPanel objects and adds three buttons to one panel, which is then nested inside the other panel.

public class Snippets {
  void panelsDemo() {
    JPanel panelA = new JPanel();                           // Outer panel
    JPanel panelB = new JPanel();                           // Inner panel

    panelB.add(new JButton("button 1"));                    // Add button 1 to inner panel
    panelB.add(new JButton("button 2"));                    // Add button 2 to inner panel
    panelB.add(new JButton("button 3"));                    // Add button 3 to inner panel

    panelA.add(panelB);                                     // Add inner panel to outer panel
  }
}
