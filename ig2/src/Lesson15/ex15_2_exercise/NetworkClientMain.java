package Lesson15.ex15_2_exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

// This class concurrently sends socket requests to ports 10000–10009 on localhost using Callables and prints the responses or errors.

public class NetworkClientMain {

    public static void main(String[] args) {
        // Create a thread pool that grows as needed
        ExecutorService es = Executors.newCachedThreadPool();

        // Map to hold each RequestResponse object and its corresponding Future
        Map<RequestResponse, Future<RequestResponse>> callables = new HashMap<>();

        String host = "localhost";

        // Submit a callable task for each port from 10000 to 10009
        for (int port = 10000; port < 10010; port++) {
            RequestResponse lookup = new RequestResponse(host, port);      // Create request object
            NetworkClientCallable callable = new NetworkClientCallable(lookup); // Wrap in Callable
            Future<RequestResponse> future = es.submit(callable);          // Submit to ExecutorService
            callables.put(lookup, future);                                 // Store in map
        }

        // Stop accepting new tasks, but allow running tasks to complete
        es.shutdown();

        try {
            // Wait up to 5 seconds for all tasks to finish
            es.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            System.out.println("Stopped waiting early");
        }

        // Process the completed futures
        for (RequestResponse lookup : callables.keySet()) {
            Future<RequestResponse> future = callables.get(lookup);
            try {
                lookup = future.get(); // Retrieve result of the callable
                System.out.println(lookup.host + ":" + lookup.port + " " + lookup.response);
            } catch (ExecutionException | InterruptedException ex) {
                // Handle task failures gracefully
                System.out.println("Error talking to " + lookup.host + ":" + lookup.port);
            }
        }

        // --- Legacy Code Block (commented out) ---
        // This older version uses blocking I/O in a single-threaded loop (not concurrent)
        /*
        for (int port = 10000; port < 10010; port++) {
            RequestResponse lookup = new RequestResponse(host, port);
            try (Socket sock = new Socket(lookup.host, lookup.port);
                 Scanner scanner = new Scanner(sock.getInputStream())) {
                lookup.response = scanner.next();
                System.out.println(lookup.host + ":" + lookup.port + " " + lookup.response);
            } catch (NoSuchElementException | IOException ex) {
                System.out.println("Error talking to " + host + ":" + port);
            }
        }
        */
    }
}
