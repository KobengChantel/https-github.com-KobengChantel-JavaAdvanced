package ch16.ex;

import ch16.GameCharacter;

import java.io.*;

// This class demonstrates various file I/O fragments in Java for serialization and reading files line by line.

public class Fragments {

  void fragment1() {
    // Incomplete code: FileReader constructor needs a file or path argument
    // FileReader fileReader = new FileReader(); ❌ Error: missing file name
    // BufferedReader reader = new BufferedReader(fileReader); ❌
  }

  void fragment2() throws IOException {
    // Creates a FileOutputStream and wraps it in an ObjectOutputStream (used for object serialization)
    FileOutputStream f = new FileOutputStream("Foo.ser");
    ObjectOutputStream os = new ObjectOutputStream(f);
    // Missing: os.writeObject(...) to actually write an object
  }

  void fragment3(File file) throws IOException {
    // Reads a file line by line and calls makeCard() for each line
    BufferedReader reader = new BufferedReader(new FileReader(file));
    String line;
    while ((line = reader.readLine()) != null) {
      makeCard(line);  // Process each line (currently empty implementation)
    }
  }

  void fragment4() throws IOException, ClassNotFoundException {
    // Incorrect: Trying to read an object using a FileOutputStream
    FileOutputStream f = new FileOutputStream("Game.ser");
    // ObjectInputStream is = new ObjectInputStream(f); ❌ Should use FileInputStream instead
    // GameCharacter oneAgain = (GameCharacter) is.readObject();
  }

  private void makeCard(String line) {
    // Placeholder method to process a line (implementation not provided)
  }
}
