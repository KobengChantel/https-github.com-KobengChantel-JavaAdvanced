package ch16;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

// This program provides a GUI quiz card player that loads a set of quiz cards from a file and allows users
// to cycle through questions and answers interactively by clicking a button.

public class QuizCardPlayer {
  private ArrayList<QuizCard> cardList;      // List of loaded quiz cards
  private int currentCardIndex;               // Index of the current card being displayed
  private QuizCard currentCard;               // The current quiz card shown
  private JTextArea display;                  // Text area to display question or answer
  private JFrame frame;                       // Main application window
  private JButton nextButton;                 // Button to show question or answer
  private boolean isShowAnswer;               // Flag to track whether to show answer or question

  public static void main(String[] args) {
    QuizCardPlayer reader = new QuizCardPlayer();
    reader.go();
  }

  public void go() {
    frame = new JFrame("Quiz Card Player");
    JPanel mainPanel = new JPanel();
    Font bigFont = new Font("sanserif", Font.BOLD, 24);

    display = new JTextArea(10, 20);
    display.setFont(bigFont);
    display.setLineWrap(true);
    display.setEditable(false);  // Prevent user editing

    JScrollPane scroller = new JScrollPane(display);
    scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    mainPanel.add(scroller);

    nextButton = new JButton("Show Question");
    nextButton.addActionListener(e -> nextCard());
    mainPanel.add(nextButton);

    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");

    JMenuItem loadMenuItem = new JMenuItem("Load card set");
    loadMenuItem.addActionListener(e -> open());

    fileMenu.add(loadMenuItem);
    menuBar.add(fileMenu);
    frame.setJMenuBar(menuBar);

    frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
    frame.setSize(500, 400);
    frame.setVisible(true);
  }

  // Handles the button click to toggle between showing question and answer,
  // or loading the next card if the answer was just shown.
  private void nextCard() {
    if (isShowAnswer) {
      // Show the answer because the question has just been shown
      display.setText(currentCard.getAnswer());
      nextButton.setText("Next Card");
      isShowAnswer = false;
    } else {
      // Show the next question or end if no more cards
      if (currentCardIndex < cardList.size()) {
        showNextCard();
      } else {
        display.setText("That was last card");
        nextButton.setEnabled(false); // Disable button since no more cards
      }
    }
  }

  // Opens a file chooser dialog to select a quiz card set file to load
  private void open() {
    JFileChooser fileOpen = new JFileChooser();
    fileOpen.showOpenDialog(frame);
    loadFile(fileOpen.getSelectedFile());
  }

  // Reads the selected file line by line, creates quiz cards, and stores them
  private void loadFile(File file) {
    cardList = new ArrayList<>();
    currentCardIndex = 0;
    try {
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line;
      while ((line = reader.readLine()) != null) {
        makeCard(line);
      }
      reader.close();
    } catch (IOException e) {
      System.out.println("Couldn't read the cardList: " + e.getMessage());
    }
    showNextCard();  // Start by showing the first card
  }

  // Parses a line to create a QuizCard and adds it to the list
  private void makeCard(String lineToParse) {
    String[] result = lineToParse.split("/");
    QuizCard card = new QuizCard(result[0], result[1]);
    cardList.add(card);
    System.out.println("made a card");
  }

  // Displays the next card's question and prepares the button to show the answer
  private void showNextCard() {
    currentCard = cardList.get(currentCardIndex);
    currentCardIndex++;
    display.setText(currentCard.getQuestion());
    nextButton.setText("Show Answer");
    isShowAnswer = true;
  }
}
