package lesson11;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

// This program demonstrates declaring a method that throws IOException and handling it in the caller.

public class TestThrows {

    public static void main(String[] args) {
        try {
            // Call method that may throw IOException
            int data = readByteFromFile();
        } catch (IOException e) {
            // Handle the IOException by printing the error message
            System.out.println(e.getMessage());
        }
    }

    // Method declares that it throws IOException, so caller must handle or declare it
    public static int readByteFromFile() throws IOException {
        // Try-with-resources ensures the InputStream is closed automatically
        try (InputStream in = new FileInputStream("a.txt")) {
            System.out.println("File open");
            // Read and return one byte from the file
            return in.read();
        }
    }
}
