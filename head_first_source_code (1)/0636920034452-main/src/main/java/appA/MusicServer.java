package appA;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

// This server program listens for client connections, receives beat patterns and messages, and broadcasts them to all connected clients.

public class MusicServer {
  // List to keep track of all connected client output streams for broadcasting
  private final List<ObjectOutputStream> clientOutputStreams = new ArrayList<>();

  public static void main(String[] args) {
    new MusicServer().go(); // Start the server
  }

  public void go() {
    try {
      // Create a server socket on port 4242
      ServerSocket serverSock = new ServerSocket(4242);
      // Create a thread pool to handle multiple clients concurrently
      ExecutorService threadPool = Executors.newCachedThreadPool();

      // Continuously listen for incoming client connections
      while (!serverSock.isClosed()) {
        Socket clientSocket = serverSock.accept(); // Accept client
        ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream()); // Prepare to send data to client
        clientOutputStreams.add(out); // Store the client's output stream for later use

        // Handle client communication in a separate thread
        ClientHandler clientHandler = new ClientHandler(clientSocket);
        threadPool.execute(clientHandler);

        System.out.println("Got a connection");
      }
    } catch (IOException e) {
      e.printStackTrace(); // Print error if server fails
    }
  }

  // Send message and beat sequence to all connected clients
  public void tellEveryone(Object usernameAndMessage, Object beatSequence) {
    for (ObjectOutputStream clientOutputStream : clientOutputStreams) {
      try {
        clientOutputStream.writeObject(usernameAndMessage);
        clientOutputStream.writeObject(beatSequence);
      } catch (IOException e) {
        e.printStackTrace(); // Handle sending error
      }
    }
  }

  // Inner class to handle incoming data from a single client
  public class ClientHandler implements Runnable {
    private ObjectInputStream in;

    public ClientHandler(Socket socket) {
      try {
        // Create an input stream to receive data from the client
        in = new ObjectInputStream(socket.getInputStream());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    // Continuously read incoming messages and beat sequences, then broadcast them
    public void run() {
      Object userNameAndMessage;
      Object beatSequence;
      try {
        while ((userNameAndMessage = in.readObject()) != null) {
          beatSequence = in.readObject(); // Read beat data

          System.out.println("read two objects");
          tellEveryone(userNameAndMessage, beatSequence); // Broadcast to all clients
        }
      } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace(); // Handle client disconnection or read error
      }
    }
  }

}
