package ch16.ex;

import java.io.*;

// This program demonstrates Java object serialization and how transient fields are not preserved after deserialization.

class DungeonGame implements Serializable {
  public int x = 3;             // Normal field (serialized)
  transient long y = 4;         // Transient field (not serialized)
  private short z = 5;          // Private field (serialized)

  int getX() {
    return x;
  }

  long getY() {
    return y;
  }

  short getZ() {
    return z;
  }
}

class DungeonTest {
  public static void main(String[] args) {
    DungeonGame d = new DungeonGame();

    // Print the sum of x + y + z before serialization
    System.out.println(d.getX() + d.getY() + d.getZ()); // 3 + 4 + 5 = 12

    try {
      // Serialize the DungeonGame object to a file
      FileOutputStream fos = new FileOutputStream("dg.ser");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(d);
      oos.close();

      // Deserialize the object back from the file
      FileInputStream fis = new FileInputStream("dg.ser");
      ObjectInputStream ois = new ObjectInputStream(fis);
      d = (DungeonGame) ois.readObject(); // Read and cast the object
      ois.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    // Print the sum of x + y + z after deserialization
    // Note: y will be 0 because it was marked transient and not saved
    System.out.println(d.getX() + d.getY() + d.getZ()); // 3 + 0 + 5 = 8
  }
}
