package ch16;

import java.io.*;
import java.util.List;

// This class demonstrates saving a list of QuizCard objects to a file using try-with-resources to automatically manage resource closing.

public class SaveWithTWR {
  private List<QuizCard> cardList;

  // Saves the cardList to the specified file, writing each card's question and answer separated by a slash and newline.
  private void saveFile(File file) {
    // Try-with-resources ensures writer and reader are automatically closed after use
    try (BufferedWriter writer =
                 new BufferedWriter(new FileWriter(file));
         BufferedReader reader =
                 new BufferedReader(new FileReader(file))) {

      for (QuizCard card : cardList) {
        writer.write(card.getQuestion() + "/");
        writer.write(card.getAnswer() + "\n");
      }
    } catch (IOException e) {
      System.out.println("Couldn't write the cardList out: " + e.getMessage());
    }
  }
}
