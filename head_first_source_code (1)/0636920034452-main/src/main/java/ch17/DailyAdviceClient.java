package ch17;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

// This code creates a TCP client that connects to a server on localhost port 5000, reads a line of advice text, and displays it to the user.

public class DailyAdviceClient {
  public void go() {
    // Create server address pointing to localhost (127.0.0.1) on port 5000
    InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1", 5000);

    // Try-with-resources: automatically opens connection to server and closes it when done
    try (SocketChannel socketChannel = SocketChannel.open(serverAddress)) {
      // Convert the socket channel to a character-based reader using UTF-8 encoding
      Reader channelReader = Channels.newReader(socketChannel, StandardCharsets.UTF_8);

      // Wrap the reader in BufferedReader for efficient line-by-line reading
      BufferedReader reader = new BufferedReader(channelReader);

      // Read one line of text from the server (the advice)
      String advice = reader.readLine();

      // Display the advice to the user
      System.out.println("Today you should: " + advice);

      // Explicitly close the reader (though try-with-resources will handle this too)
      reader.close();
    } catch (IOException e) {
      // Handle any network or I/O errors that might occur
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    // Create an instance of the client and run it
    new DailyAdviceClient().go();
  }
}