package ch15;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

// This program creates a GUI with a scrollable list where selecting an item prints the selected value to the console.

public class ListExample implements ListSelectionListener {
  private JList<String> list;

  public static void main(String[] args) {
    ListExample gui = new ListExample();
    gui.go();
  }

  public void go() {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    String[] listEntries = {"alpha", "beta", "gamma", "delta",
            "epsilon", "zeta", "eta", "theta "};

    list = new JList<>(listEntries);
    list.setVisibleRowCount(4);                             // Show 4 rows at a time
    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Only one selection allowed
    list.addListSelectionListener(this);                    // Add listener for selection changes

    JScrollPane scroller = new JScrollPane(list);
    scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    panel.add(scroller);

    frame.getContentPane().add(BorderLayout.CENTER, panel);

    frame.setSize(200, 150);
    frame.setVisible(true);
  }

  // Called when the list selection changes
  public void valueChanged(ListSelectionEvent e) {
    if (!e.getValueIsAdjusting()) {                      // Only act after the user finishes adjusting
      String selection = list.getSelectedValue();        // Get the selected item
      System.out.println(selection);                      // Print selected value to console
    }
  }
}
