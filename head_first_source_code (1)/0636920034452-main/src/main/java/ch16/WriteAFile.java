package ch16;

import java.io.*;

// This class writes the string "hello foo!" to a text file named "Foo.txt".

class WriteAFile {
  public static void main(String[] args) {
    try {
      // Create a FileWriter object to write characters to "Foo.txt"
      FileWriter writer = new FileWriter("Foo.txt");
      // Write the string "hello foo!" into the file
      writer.write("hello foo!");
      // Close the writer to flush and release system resources
      writer.close();
    } catch (IOException ex) {
      // Print any IO exceptions that occur during file writing
      ex.printStackTrace();
    }
  }
}
