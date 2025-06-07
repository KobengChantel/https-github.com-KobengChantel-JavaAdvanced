package Lesson15.ex15_2_exercise;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// This class starts multiple server instances on ports 10000–10009 to simulate network responses for client testing.

public class NetworkServerMain {

    public static void main(String[] args) {
        // Create a thread pool that grows as needed
        ExecutorService exSrv = Executors.newCachedThreadPool();

        // List to store all runnable server instances
        List<Runnable> runners = new ArrayList<>();

        // Attempt to start a server on each port from 10000 to 10009
        for (int port = 10000; port < 10010; port++) {
            Runnable r;
            try {
                // Create a server on given port with a simulated price range of 20 to 110
                r = new PriceRangeServer(port, 20, 110);
                runners.add(r);  // Add the runnable to the list
            } catch (IOException ex) {
                // If the port is already in use, skip it and show a message
                System.out.println("Port " + port + " already in use");
            }
        }

        // Start all server runnables in the thread pool
        for (Runnable r : runners) {
            exSrv.execute(r);
        }

        // Allow servers to initialize briefly
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            // Ignore interruption
        }

        // Wait for user to press Enter to terminate all servers
        System.out.println("Press enter to quit...");
        try {
            System.in.read();
        } catch (IOException ex) {
            // Ignore input exception
        }

        System.out.println("Quitting...");
        // Force shutdown of all server threads
        exSrv.shutdownNow();
    }
}
