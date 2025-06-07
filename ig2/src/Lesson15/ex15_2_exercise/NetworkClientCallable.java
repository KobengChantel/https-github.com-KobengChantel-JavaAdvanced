package Lesson15.ex15_2_exercise;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Callable;

// This class defines a Callable that opens a socket connection to a host and port, reads a single response, and returns it in a RequestResponse object.

public class NetworkClientCallable implements Callable<RequestResponse> {

    // The request/response data holder (contains host, port, and response fields)
    private final RequestResponse lookup;

    // Constructor to initialize the request details
    public NetworkClientCallable(RequestResponse lookup) {
        this.lookup = lookup;
    }

    @Override
    public RequestResponse call() throws IOException {
        // Try-with-resources to automatically close socket and scanner
        try (Socket sock = new Socket(lookup.host, lookup.port);        // Connect to the given host and port
             Scanner scanner = new Scanner(sock.getInputStream())) {    // Read data from the socket's input stream

            lookup.response = scanner.next();    // Read the next token from the input stream and store as response
            return lookup;                       // Return the updated request/response object
        }
    }
}
