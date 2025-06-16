package ch17;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.*;
import java.util.concurrent.*;

import static java.nio.charset.StandardCharsets.UTF_8;

// This code creates a multi-threaded chat server that listens on port 5000, accepts multiple client connections, and broadcasts every message received from any client to all connected clients using a thread pool.

public class SimpleChatServer {
  // List to store PrintWriter objects for all connected clients
  private final List<PrintWriter> clientWriters = new ArrayList<>();

  public static void main(String[] args) {
    // Create and start the chat server
    new SimpleChatServer().go();
  }

  public void go() {
    // Create a cached thread pool that creates threads as needed
    ExecutorService threadPool = Executors.newCachedThreadPool();
    try {
      // Create server socket channel and bind to port 5000
      ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
      serverSocketChannel.bind(new InetSocketAddress(5000));

      // Main server loop - continuously accept new client connections
      while (serverSocketChannel.isOpen()) {
        // Wait for and accept a new client connection (blocking call)
        SocketChannel clientSocket = serverSocketChannel.accept();

        // Create PrintWriter for sending messages to this client
        PrintWriter writer = new PrintWriter(Channels.newWriter(clientSocket, UTF_8));

        // Add this client's writer to the list of all clients
        clientWriters.add(writer);

        // Submit a new ClientHandler task to handle this client's messages
        threadPool.submit(new ClientHandler(clientSocket));

        System.out.println("got a connection");
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  // Method to broadcast a message to all connected clients
  private void tellEveryone(String message) {
    // Iterate through all client writers
    for (PrintWriter writer : clientWriters) {
      // Send the message to each client
      writer.println(message);
      writer.flush();  // Ensure message is sent immediately
    }
  }

  // Inner class that handles messages from a specific client
  public class ClientHandler implements Runnable {
    BufferedReader reader;  // For reading messages from this client
    SocketChannel socket;   // The client's socket connection

    // Constructor - set up reader for this client
    public ClientHandler(SocketChannel clientSocket) {
      socket = clientSocket;
      // Create BufferedReader to read text messages from client
      reader = new BufferedReader(Channels.newReader(socket, UTF_8));
    }

    // Run method - continuously read messages from this client
    public void run() {
      String message;
      try {
        // Keep reading messages until client disconnects (readLine returns null)
        while ((message = reader.readLine()) != null) {
          System.out.println("read " + message);  // Log message to server console
          tellEveryone(message);                   // Broadcast message to all clients
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }
}