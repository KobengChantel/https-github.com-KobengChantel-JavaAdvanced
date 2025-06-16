package ch15;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// This class contains JUnit tests demonstrating the behavior of Java NIO channels for networking, focusing on socket connections, port binding, blocking vs non-blocking modes, and stream reading/writing with channels.

class ConceptsTest {

  @Test
  @Disabled("This test doesn't pass or fail. I was using it to see if I could generate exceptions")
  void testConnect() throws IOException {
    // Create a socket address for localhost on port 4242
    SocketAddress remote1 = new InetSocketAddress("127.0.0.1", 4242);

    // Open a server socket channel and bind it to port 4242
    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
    serverSocketChannel.bind(remote1);

    // Create another socket address with the same host and port
    SocketAddress remote2 = new InetSocketAddress("127.0.0.1", 4242);
    // Open a client socket channel connecting to the server address
    SocketChannel.open(remote2);

    // Open a classic socket connecting to localhost at port 4242
    Socket socket = new Socket("localhost", 4242);
  }

  @Test
  void testChannelPortNumbers() throws IOException {
    // Bind a server socket channel to localhost on port 3602
    SocketAddress serverAddress = new InetSocketAddress("127.0.0.1", 3602);
    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
    serverSocketChannel.bind(serverAddress);

    // Open two client socket channels connecting to the server
    SocketChannel client1 = SocketChannel.open(serverAddress);
    System.out.println("client1.getRemoteAddress() = " + client1.getRemoteAddress());
    SocketChannel client2 = SocketChannel.open(serverAddress);
    System.out.println("client2.getRemoteAddress() = " + client2.getRemoteAddress());
  }

  @Test
  void testBlockingVsNonBlocking() throws IOException {
    // Bind a server socket channel to localhost on port 3600
    int serverPort = 3600;
    ServerSocketChannel server = ServerSocketChannel.open();
    server.bind(new InetSocketAddress("localhost", serverPort));
    System.out.println("server.isBlocking() = " + server.isBlocking());

    // Open a client socket channel connecting to the server
    SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", serverPort));
    System.out.println("socketChannel.isBlocking() = " + socketChannel.isBlocking());

    // Configure the client socket channel to blocking mode and print its state
    socketChannel.configureBlocking(true);
    System.out.println("socketChannel.isBlocking() = " + socketChannel.isBlocking());

    // Configure the client socket channel to non-blocking mode and print its state
    socketChannel.configureBlocking(false);
    System.out.println("socketChannel.isBlocking() = " + socketChannel.isBlocking());
  }

  @Test
  void testInputStreamsWithNonBlockingChannel() throws IOException, InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    CountDownLatch latch = new CountDownLatch(1);
    int serverPort = 3601;

    // Setup a server socket channel bound to localhost on port 3601
    ServerSocketChannel server = ServerSocketChannel.open();
    server.bind(new InetSocketAddress("localhost", serverPort));

    // Start a server thread that accepts client connections and writes a string to them
    executorService.submit(() -> {
      try {
        while (true) {
          SocketChannel client = server.accept();
          Writer writer = Channels.newWriter(client, StandardCharsets.UTF_8);
          writer.write("hey there");
          writer.flush();
          System.out.println("done");
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    });

    // Open a client socket channel connecting to the server and set it to non-blocking mode
    SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", serverPort));
    socketChannel.configureBlocking(false);

    // Start a client thread that reads data from the socket channel using a Reader
    executorService.submit(() -> {
      Reader reader = Channels.newReader(socketChannel, StandardCharsets.UTF_8);
      try {
        while (socketChannel.isOpen()) {
          System.out.println(reader.read());
          latch.countDown();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    });

    // Wait for the client thread to read at least one character before finishing the test
    latch.await();
  }
}
