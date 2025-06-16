package ch17;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Random;

// This code creates a TCP server that listens on port 5000 and sends a random piece of advice to each client that connects, then closes the connection.

public class DailyAdviceServer {
  // Array of advice strings to randomly choose from
  final private String[] adviceList = {
          "Take smaller bites",
          "Go for the tight jeans. No they do NOT make you look fat.",
          "One word: inappropriate",
          "Just for today, be honest. Tell your boss what you *really* think",
          "You might want to rethink that haircut."};

  // Random number generator for selecting advice
  private final Random random = new Random();

  public void go() {
    // Try-with-resources: create and automatically close server socket channel
    try (ServerSocketChannel serverChannel = ServerSocketChannel.open()) {
      // Bind the server to listen on port 5000 on all network interfaces
      serverChannel.bind(new InetSocketAddress(5000));

      // Keep server running while the channel is open
      while (serverChannel.isOpen()) {
        // Wait for and accept a client connection (blocking call)
        SocketChannel clientChannel = serverChannel.accept();

        // Create a PrintWriter to send text data to the client
        PrintWriter writer = new PrintWriter(Channels.newOutputStream(clientChannel));

        // Get a random piece of advice
        String advice = getAdvice();

        // Send the advice to the client followed by a newline
        writer.println(advice);

        // Close the writer (and underlying connection to client)
        writer.close();

        // Log the advice that was sent to the server console
        System.out.println(advice);
      }

    } catch (IOException ex) {
      // Handle any network or I/O errors
      ex.printStackTrace();
    }
  }

  // Helper method to select random advice from the array
  private String getAdvice() {
    // Generate random index within bounds of advice array
    int nextAdvice = random.nextInt(adviceList.length);
    // Return the advice at that index
    return adviceList[nextAdvice];
  }

  public static void main(String[] args) {
    // Create server instance and start it
    new DailyAdviceServer().go();
  }
}