package ch17;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.*;

import static java.nio.charset.StandardCharsets.UTF_8;

// This code creates a simplified GUI chat client that can only send messages to a server on localhost port 5000 without displaying incoming messages or using background threads.

public class SimpleChatClientA {
  // GUI component for typing outgoing messages
  private JTextField outgoing;

  // Network component for sending messages to server
  private PrintWriter writer;

  public void go() {
    // Establish network connection to chat server
    setUpNetworking();

    // Create text field for typing messages
    outgoing = new JTextField(20);

    // Create send button with action listener
    JButton sendButton = new JButton("Send");
    sendButton.addActionListener(e -> sendMessage());

    // Create simple panel with just input field and send button
    JPanel mainPanel = new JPanel();
    mainPanel.add(outgoing);
    mainPanel.add(sendButton);

    // Create and configure main window (smaller than full chat client)
    JFrame frame = new JFrame("Ludicrously Simple Chat Client");
    frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
    frame.setSize(400, 100);  // Smaller height since no message display area
    frame.setVisible(true);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }

  private void setUpNetworking() {
    try {
      // Connect to chat server on localhost port 5000
      InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1", 5000);
      SocketChannel socketChannel = SocketChannel.open(serverAddress);

      // Create writer for sending text messages using UTF-8 encoding
      writer = new PrintWriter(Channels.newWriter(socketChannel, UTF_8));

      // Log successful connection
      System.out.println("Networking established. Client running at: " + socketChannel.getLocalAddress());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void sendMessage() {
    // Send the message from the text field to the server
    writer.println(outgoing.getText());
    writer.flush();                    // Ensure message is sent immediately
    outgoing.setText("");              // Clear the input field
    outgoing.requestFocus();           // Keep focus on input field for next message
  }

  public static void main(String[] args) {
    // Create and start the simplified chat client
    new SimpleChatClientA().go();
  }
}