package ch17.magnet;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.time.format.FormatStyle;
import java.util.concurrent.TimeUnit;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.time.LocalDateTime.now;
import static java.time.format.DateTimeFormatter.ofLocalizedTime;

// This code creates a TCP client that connects to a local server and sends ten "ping" messages, one per second, while printing timestamps and sent messages.

public class PingingClient {

  public static void main(String[] args) {
    // Define server address and port to connect to
    InetSocketAddress server = new InetSocketAddress("127.0.0.1", 5000);

    // Try-with-resources to open a SocketChannel connected to the server (auto-closes)
    try (SocketChannel channel = SocketChannel.open(server)) {
      // Wrap the SocketChannel's output into a PrintWriter with UTF-8 encoding
      PrintWriter writer = new PrintWriter(Channels.newWriter(channel, UTF_8));
      System.out.println("Networking established");

      // Loop 10 times to send ping messages
      for (int i = 0; i < 10; i++) {
        String message = "ping " + i;          // Prepare the message to send
        writer.println(message);               // Send the message with newline
        writer.flush();                        // Ensure the message is sent immediately

        // Get current time formatted in medium style (e.g., 10:15:30 AM)
        String currentTime = now().format(ofLocalizedTime(FormatStyle.MEDIUM));
        // Print the time and the message sent
        System.out.println(currentTime + " Sent " + message);

        // Wait for 1 second before next ping
        TimeUnit.SECONDS.sleep(1);
      }
    } catch (IOException | InterruptedException e) {
      // Print stack trace if an IO or interrupt exception occurs
      e.printStackTrace();
    }
  }
}
