package ch16;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

// This program provides a GUI for building quiz cards with questions and answers,
// allowing users to create, save, and clear multiple quiz cards through a simple interface.

public class QuizCardBuilder {
  private ArrayList<QuizCard> cardList = new ArrayList<>();  // Stores created quiz cards
  private JTextArea question;                                // Text area for entering question
  private JTextArea answer;                                  // Text area for entering answer
  private JFrame frame;                                      // Main window frame

  public static void main(String[] args) {
    new QuizCardBuilder().go();
  }

  public void go() {
    frame = new JFrame("Quiz Card Builder");
    JPanel mainPanel = new JPanel();
    Font bigFont = new Font("sanserif", Font.BOLD, 24);

    // Setup question input area with scroll pane
    question = createTextArea(bigFont);
    JScrollPane qScroller = createScroller(question);

    // Setup answer input area with scroll pane
    answer = createTextArea(bigFont);
    JScrollPane aScroller = createScroller(answer);

    mainPanel.add(new JLabel("Question:"));
    mainPanel.add(qScroller);

    mainPanel.add(new JLabel("Answer:"));
    mainPanel.add(aScroller);

    // Button to add the current question and answer as a new card
    JButton nextButton = new JButton("Next Card");
    nextButton.addActionListener(e -> nextCard());
    mainPanel.add(nextButton);

    // Menu bar with File menu containing New and Save options
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");

    JMenuItem newMenuItem = new JMenuItem("New");
    newMenuItem.addActionListener(e -> clearAll());

    JMenuItem saveMenuItem = new JMenuItem("Save");
    saveMenuItem.addActionListener(e -> saveCard());

    fileMenu.add(newMenuItem);
    fileMenu.add(saveMenuItem);
    menuBar.add(fileMenu);
    frame.setJMenuBar(menuBar);

    frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
    frame.setSize(500, 600);
    frame.setVisible(true);
  }

  // Creates a scroll pane for the given JTextArea
  private JScrollPane createScroller(JTextArea textArea) {
    JScrollPane scroller = new JScrollPane(textArea);
    scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    return scroller;
  }

  // Configures a JTextArea with line wrapping and font
  private JTextArea createTextArea(Font font) {
    JTextArea textArea = new JTextArea(6, 20);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setFont(font);
    return textArea;
  }

  // Adds the current question and answer as a QuizCard to the list, then clears inputs
  private void nextCard() {
    QuizCard card = new QuizCard(question.getText(), answer.getText());
    cardList.add(card);
    clearCard();
  }

  // Saves the current card and writes all cards to a user-chosen file
  private void saveCard() {
    QuizCard card = new QuizCard(question.getText(), answer.getText());
    cardList.add(card);

    JFileChooser fileSave = new JFileChooser();
    fileSave.showSaveDialog(frame);
    saveFile(fileSave.getSelectedFile());
  }

  // Clears the list of cards and resets the input fields
  private void clearAll() {
    cardList.clear();
    clearCard();
  }

  // Clears the question and answer input fields and sets focus to the question
  private void clearCard() {
    question.setText("");
    answer.setText("");
    question.requestFocus();
  }

  // Writes all quiz cards to the specified file, formatting each as "question/answer\n"
  private void saveFile(File file) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(file));
      for (QuizCard card : cardList) {
        writer.write(card.getQuestion() + "/");
        writer.write(card.getAnswer() + "\n");
      }
      writer.close();
    } catch (IOException e) {
      System.out.println("Couldn't write the cardList out: " + e.getMessage());
    }
  }
}
