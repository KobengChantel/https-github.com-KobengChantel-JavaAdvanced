package ch16;

import java.io.*;

// This program demonstrates saving and restoring GameCharacter objects by serializing them to and deserializing them from a file.

public class GameSaverTest {
  public static void main(String[] args) {
    // Create three GameCharacter instances with different attributes
    GameCharacter one = new GameCharacter(50, "Elf",
            new String[]{"bow", "sword", "dust"});
    GameCharacter two = new GameCharacter(200, "Troll",
            new String[]{"bare hands", "big ax"});
    GameCharacter three = new GameCharacter(120, "Magician",
            new String[]{"spells", "invisibility"});

    // Code here might modify the character states before saving

    try {
      // Serialize the GameCharacter objects to a file named "Game.ser"
      ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
      os.writeObject(one);
      os.writeObject(two);
      os.writeObject(three);
      os.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    try {
      // Deserialize the GameCharacter objects from the file "Game.ser"
      ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
      GameCharacter oneRestore = (GameCharacter) is.readObject();
      GameCharacter twoRestore = (GameCharacter) is.readObject();
      GameCharacter threeRestore = (GameCharacter) is.readObject();

      // Print the type of each restored GameCharacter to verify successful deserialization
      System.out.println("One's type: " + oneRestore.getType());
      System.out.println("Two's type: " + twoRestore.getType());
      System.out.println("Three's type: " + threeRestore.getType());
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
