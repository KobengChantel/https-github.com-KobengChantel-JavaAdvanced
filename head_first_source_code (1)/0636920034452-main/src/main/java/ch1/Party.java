package ch1;

import java.awt.*;
import java.awt.event.*;

// This code sets up a basic GUI with a frame, label, buttons, and a panel, preparing a simple party invitation interface.

class Party {
  public void buildInvite() {
    Frame f = new Frame();                 // Create a new window frame
    Label l = new Label("Party at Tim's"); // Create a label with invitation text
    Button b = new Button("You bet");      // Create a button labeled "You bet"
    Button c = new Button("Shoot me");      // Create another button labeled "Shoot me"
    Panel p = new Panel();                   // Create a panel to hold components
    p.add(l);                              // Add the label to the panel
  }   // more code here...
}
