package Lesson15.ex15_2_exercise;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

// This class simulates a simple price server that listens on a given port and returns a random price to each client.

public class PriceRangeServer implements Runnable {

    private String price;
    private ServerSocket ss;

    /**
     * Constructor that sets up a server on a specific port and generates a random price in the given range.
     *
     * @param port the port number the server will listen on
     * @param low  the minimum price (inclusive)
     * @param high the maximum price (exclusive)
     * @throws IOException if the server socket cannot be opened
     */
    public PriceRangeServer(int port, int low, int high) throws IOException {
        ss = new ServerSocket(port); // Bind server to the specified port
        ss.setSoTimeout(250); // Set timeout to allow periodic interruption checks

        // Generate a random price within the given range and format it to 2 decimal places
        double d = Math.random() * (high - low) + low;
        price = String.format("%.2f", d);
    }

    /**
     * Continuously accepts client connections and sends the generated price.
     *
     * @throws IOException if an I/O error occurs while accepting a connection
     */
    public void accept() throws IOException {
        System.out.println("Accepting connections on port " + ss.getLocalPort());

        // Keep accepting connections unless interrupted
        while (!Thread.interrupted()) {
            try (
                    Socket sock = ss.accept(); // Accept an incoming connection
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()))
            ) {
                try {
                    Thread.sleep(2000); // Simulate processing delay
                } catch (InterruptedException ex) {
                    return; // Exit if interrupted during sleep
                }

                bw.write(price); // Send the price to the client
            } catch (SocketTimeoutException ste) {
                // Ignore timeout: this allows checking for thread interruption
            }
        }

        System.out.println("Done accepting");
    }

    /**
     * Entry point when the server is run in a separate thread.
     */
    @Override
    public void run() {
        try {
            accept();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
