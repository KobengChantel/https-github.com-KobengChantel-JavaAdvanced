package ch16;

// This class represents a QuizCard with a question and its corresponding answer.

public class QuizCard {
  private final String question;  // The question text
  private final String answer;    // The answer text

  public QuizCard(String question, String answer) {
    this.question = question;     // Initialize question
    this.answer = answer;         // Initialize answer
  }

  public String getQuestion() {
    return question;              // Return the question text
  }

  public String getAnswer() {
    return answer;                // Return the answer text
  }
}
