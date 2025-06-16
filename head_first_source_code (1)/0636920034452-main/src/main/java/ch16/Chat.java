package ch16;

import java.io.*;

// This class defines a serializable Chat object with one transient field (excluded from serialization) and one serializable field.

class Chat implements Serializable {
  transient String currentID;  // This field will NOT be saved during serialization (e.g., session ID)

  String userName;             // This field WILL be saved when the object is serialized

  // more code can go here (e.g., constructors, methods)
}
