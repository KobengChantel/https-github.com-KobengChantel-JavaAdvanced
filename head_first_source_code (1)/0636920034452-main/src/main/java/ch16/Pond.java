package ch16;

import java.io.*;

// This class demonstrates serialization by saving a Pond object (which contains a Duck) to a file.

public class Pond implements Serializable {
  private Duck duck = new Duck();  // Pond has a Duck instance

  public static void main(String[] args) {
    Pond myPond = new Pond();       // Create a Pond object
    try {
      FileOutputStream fs = new FileOutputStream("Pond.ser");   // File output stream to write to Pond.ser
      ObjectOutputStream os = new ObjectOutputStream(fs);       // Wrap with ObjectOutputStream for serialization
      os.writeObject(myPond);                                   // Serialize Pond object (and Duck inside it)
      os.close();                                               // Close stream
    } catch (Exception ex) {
      ex.printStackTrace();                                     // Print errors if any
    }
  }
}
