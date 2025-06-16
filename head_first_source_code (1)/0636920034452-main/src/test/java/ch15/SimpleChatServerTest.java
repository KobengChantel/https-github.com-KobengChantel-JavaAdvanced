package ch15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertTrue;

// Needs a SimpleChatServer running (is not a real unit test class, more like an integration test)
@Disabled
class SimpleChatServerTest {
  @Test
  void testSend() throws IOException {
    Socket socket = connect();
    assertTrue(send(socket, "Hi"));
    socket.close();
  }

  @Test
  // this will work if run when there are no other clients connected
  // this will likely hang if other clients are already connected (e.g. running testReceive)
  void testSendAndReceive() throws IOException, InterruptedException {
    Socket socket = connect();
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    executorService.submit(() -> Assertions.assertEquals("Hi", receive(socket)));
    assertTrue(send(socket, "Hi"));
    Thread.sleep(10_000);
    socket.close();
  }

  @Test
  // NOT a real unit test - run this to have a client sat waiting for a response. You can get this to
  // pass by sending "Hi" to the server with another client, e.g. by calling testSend.
  void testReceive() throws IOException {
    Socket socket = connect();
    Assertions.assertEquals("Hi", receive(socket));
    socket.close();
  }

  public boolean send(Socket socket, String payload) throws IOException {
    // Create a PrintWriter wrapping the socket's output stream for sending text data
    PrintWriter writer = new PrintWriter(socket.getOutputStream());

    // Write the payload string followed by a newline and flush to send immediately
    writer.println(payload);
    writer.flush();

    // Indicate that the send operation was successful
    return true;
  }

  public String receive(Socket socket) {
    // Use try-with-resources to automatically close the stream reader and buffered reader
    try (InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
         BufferedReader reader = new BufferedReader(streamReader)) {

      // Read a line of text from the socket input stream
      String message = reader.readLine();
      System.out.println("read " + message);

      // Return the received message
      return message;

    } catch (IOException e) {
      // Print stack trace if reading fails
      e.printStackTrace();
    }
    // Return null if an exception occurred or no message was read
    return null;
  }

  private Socket connect() throws IOException {
    // Create a new socket and connect it to localhost on port 5000
    Socket socket = new Socket("127.0.0.1", 5000);

    // Print the local port assigned to this socket after connection
    System.out.println(socket.getLocalPort() + " connected");

    // Return the connected socket
    return socket;
  }}

