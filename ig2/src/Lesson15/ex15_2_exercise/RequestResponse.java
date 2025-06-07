package Lesson15.ex15_2_exercise;

import java.util.Objects;

// This class holds request (host, port) and response data used in client-server communication.

public class RequestResponse {

    public String host;      // Hostname or IP address (e.g., "localhost")
    public int port;         // Port number for the connection
    public String response;  // Server's response after the request

    // Constructor to initialize host and port
    public RequestResponse(String host, int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * Checks equality based on host and port only, not the response.
     * Useful for using this object as a key in maps.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RequestResponse) {
            RequestResponse lookup = (RequestResponse) obj;
            return host.equals(lookup.host) && port == lookup.port;
        }
        return false;
    }

    /**
     * Generates a hash code based on host and port for use in hash-based collections.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.host); // hash host string
        hash = 97 * hash + this.port;                   // include port number
        return hash;
    }
}
