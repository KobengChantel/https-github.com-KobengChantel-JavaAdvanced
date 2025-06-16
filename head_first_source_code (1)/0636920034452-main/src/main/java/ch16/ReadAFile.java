package ch16;

import java.io.*;

// This program reads a text file named "MyText.txt" line by line and prints each line to the console.

class ReadAFile {
  public static void main(String[] args) {
    try {
      File myFile = new File("MyText.txt");          // Create a File object for "MyText.txt"
      FileReader fileReader = new FileReader(myFile); // FileReader to read characters from the file

      BufferedReader reader = new BufferedReader(fileReader); // BufferedReader to read lines efficiently

      String line;
      // Read each line until there are no more lines (null)
      while ((line = reader.readLine()) != null) {
        System.out.println(line);                     // Print the current line
      }
      reader.close();                                 // Close the reader to free resources

    } catch (IOException e) {
      e.printStackTrace();                            // Print error details if file is not found or read fails
    }
  }
}
