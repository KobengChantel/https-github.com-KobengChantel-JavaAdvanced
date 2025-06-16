package ch16;

import java.io.*;

// This class defines a serializable Square object and demonstrates saving its instance to a file.

public class Square implements Serializable {
  // Width of the square
  private int width;
  // Height of the square
  private int height;

  // Constructor to initialize width and height
  public Square(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public static void main(String[] args) {
    // Create a new Square instance
    Square mySquare = new Square(50, 20);

    try {
      // Create a FileOutputStream to write to file "foo.ser"
      FileOutputStream fs = new FileOutputStream("foo.ser");
      // Create an ObjectOutputStream to serialize the object
      ObjectOutputStream os = new ObjectOutputStream(fs);
      // Write the Square object to the output stream (serialize it)
      os.writeObject(mySquare);
      // Close the output stream to release resources
      os.close();
    } catch (Exception ex) {
      // Print any exceptions that occur during serialization
      ex.printStackTrace();
    }
  }
}
