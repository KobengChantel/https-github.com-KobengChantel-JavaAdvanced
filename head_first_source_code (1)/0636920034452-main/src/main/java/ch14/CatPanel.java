package ch14;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

// This program creates a window displaying an image ("catzilla.jpg") using a custom JPanel that implements ImageObserver for image loading status.

public class CatPanel extends JPanel implements ImageObserver {
  public void paintComponent(Graphics g) {
    Image image = new ImageIcon("catzilla.jpg").getImage();

    g.drawImage(image, 3, 4, this);  // Draw the image at position (3,4), using this panel as the image observer
  }

  // Called when more information about the image is available (loading progress), but here it simply returns false to stop updates
  public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
    return false;
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();             // Create a new window
    frame.add(new CatPanel());                // Add the CatPanel (which displays the image) to the window
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit program when window closes
    frame.setSize(300, 300);                  // Set window size
    frame.setVisible(true);                   // Make window visible
  }
}
