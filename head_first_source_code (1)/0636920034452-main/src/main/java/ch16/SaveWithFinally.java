package ch16;

import java.io.*;
import java.util.List;

// This class saves a list of QuizCard objects to a specified file, ensuring the BufferedWriter is closed properly even if an exception occurs.

public class SaveWithFinally {
  private List<QuizCard> cardList; // List of quiz cards to save

  // Saves the cardList to the given file, writing each card's question and answer separated by a slash and a newline.
  private void saveFile(File file) {
    BufferedWriter writer = null;
    try {
      writer = new BufferedWriter(new FileWriter(file));

      for (QuizCard card : cardList) {
        writer.write(card.getQuestion() + "/");
        writer.write(card.getAnswer() + "\n");
      }

    } catch (IOException e) {
      System.out.println("Couldn't write the cardList out: " + e.getMessage());
    } finally {
      try {
        if (writer != null) {
          writer.close(); // Ensure the writer is closed even if an error occurs
        }
      } catch (Exception e) {
        System.out.println("Couldn't close writer: " + e.getMessage());
      }
    }
  }
}
