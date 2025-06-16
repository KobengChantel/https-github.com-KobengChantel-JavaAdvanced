package ch18;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;

import static java.time.format.DateTimeFormatter.ofLocalizedTime;
import static java.time.format.FormatStyle.MEDIUM;

// This program demonstrates unsafe concurrent access to a non-thread-safe List by multiple threads performing reads and writes simultaneously.

public class ConcurrentReaders {
  public static void main(String[] args) {
    // A non-thread-safe list to store chat messages
    List<Chat> chatHistory = new ArrayList<>();

    // A thread pool with 3 threads
    ExecutorService executor = Executors.newFixedThreadPool(3);

    // Submit multiple writer and reader tasks to the executor
    for (int i = 0; i < 5; i++) {
      // Writer task: adds a new Chat message
      executor.execute(() -> chatHistory.add(new Chat("Hi there!")));

      // Reader tasks: print the current chat history
      executor.execute(() -> System.out.println(chatHistory));
      executor.execute(() -> System.out.println(chatHistory));
    }

    // Shutdown the executor (no new tasks accepted)
    executor.shutdown();
  }
}

// Represents a chat message with a timestamp
final class Chat {
  private final String message;
  private final LocalDateTime timestamp;

  // Initialize message and capture creation time
  public Chat(String message) {
    this.message = message;
    timestamp = LocalDateTime.now();
  }

  // Format and return message with time
  public String toString() {
    String time = timestamp.format(ofLocalizedTime(MEDIUM));
    return time + " " + message;
  }
}
