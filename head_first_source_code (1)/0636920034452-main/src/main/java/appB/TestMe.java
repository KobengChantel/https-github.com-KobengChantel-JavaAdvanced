package appB;

// This class defines an immutable TestMe object that stores a message string and provides a getter to access it.

public class TestMe {
  // Private final field to hold the message, ensuring immutability after construction
  private final String message;

  // Constructor initializes the message field
  public TestMe(String message) {
    this.message = message;
  }

  // Getter method to retrieve the stored message
  public String getMessage() {
    return message;
  }
}
