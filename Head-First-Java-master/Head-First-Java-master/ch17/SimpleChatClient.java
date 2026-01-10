package ch17;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.concurrent.*;

import static java.nio.charset.StandardCharsets.UTF_8;

// This code creates a simple GUI chat client that connects to a server on localhost port 5000, uses a separate thread to continuously read incoming messages, and allows users to send messages through a text field and button interface.

public class SimpleChatClient {
  // GUI components for displaying and sending messages
  private JTextArea incoming;
  private JTextField outgoing;

  // Network I/O components for communication with server
  private BufferedReader reader;
  private PrintWriter writer;

  public void go() {
    // Establish network connection to chat server
    setUpNetworking();

    // Create scrollable text area for displaying incoming messages
    JScrollPane scroller = createScrollableTextArea();

    // Create text field for typing outgoing messages
    outgoing = new JTextField(20);

    // Create send button and attach action listener
    JButton sendButton = new JButton("Send");
    sendButton.addActionListener(e -> sendMessage());

    // Create main panel and add all components
    JPanel mainPanel = new JPanel();
    mainPanel.add(scroller);
    mainPanel.add(outgoing);
    mainPanel.add(sendButton);

    // Create background thread to continuously read incoming messages
    ExecutorService executor = Executors.newSingleThreadExecutor();
    executor.execute(new IncomingReader());

    // Create and configure main window
    JFrame frame = new JFrame("Ludicrously Simple Chat Client");
    frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
    frame.setSize(400, 350);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }

  private JScrollPane createScrollableTextArea() {
    // Create text area for displaying incoming messages
    incoming = new JTextArea(15, 30);
    incoming.setLineWrap(true);        // Wrap long lines
    incoming.setWrapStyleWord(true);   // Wrap at word boundaries
    incoming.setEditable(false);       // Read-only for incoming messages

    // Wrap text area in scroll pane
    JScrollPane scroller = new JScrollPane(incoming);
    scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    return scroller;
  }

  private void setUpNetworking() {
    try {
      // Connect to chat server on localhost port 5000
      InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1", 5000);
      SocketChannel socketChannel = SocketChannel.open(serverAddress);

      // Create reader and writer for text communication using UTF-8 encoding
      reader = new BufferedReader(Channels.newReader(socketChannel, UTF_8));
      writer = new PrintWriter(Channels.newWriter(socketChannel, UTF_8));

      // Log successful connection
      System.out.println("Networking established. Client running at: " + socketChannel.getLocalAddress());
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  private void sendMessage() {
    // Send the message from the text field to the server
    writer.println(outgoing.getText());
    writer.flush();                    // Ensure message is sent immediately
    outgoing.setText("");              // Clear the input field
    outgoing.requestFocus();           // Keep focus on input field for next message
  }

  // Inner class that runs on background thread to read incoming messages
  public class IncomingReader implements Runnable {
    public void run() {
      String message;
      try {
        // Continuously read messages from server until connection closes
        while ((message = reader.readLine()) != null) {
          System.out.println("read " + message);           // Log to console
          incoming.append(message + "\n");                 // Display in GUI
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    // Create and start the chat client
    new SimpleChatClient().go();
  }
}