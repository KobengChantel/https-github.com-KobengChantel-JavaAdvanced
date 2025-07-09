package lesson11;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

// This program demonstrates throwing and rethrowing an IOException if a file is too large when reading a byte from it.

public class TestThrow {

    public static void main(String[] args) {
        try {
            // Attempt to read a byte from the file
            int data = readByteFromFile();
        } catch (IOException e) {
            // Handle any IOException thrown by readByteFromFile
            System.out.println(e.getMessage());
        }
    }

    // Method that reads a byte from "a.txt" but throws IOException if file size exceeds 250 bytes
    public static int readByteFromFile() throws IOException {
        try {
            File f = new File("a.txt");
            InputStream in = new FileInputStream(f);
            System.out.println("File open");

            // Check file size and throw IOException if file is too big
            if (f.length() > 250)
                throw new IOException("File too big");

            // Read and return one byte from the file
            return in.read();

        } catch (IOException e) {
            // Print stack trace and rethrow exception for the caller to handle
            e.printStackTrace();
            throw e;
        }
    }
}
