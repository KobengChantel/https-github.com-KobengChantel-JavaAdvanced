package lesson11;

import java.io.FileInputStream;
import java.io.InputStream;

// This program demonstrates basic try-catch to handle exceptions when attempting to open a file.

public class TestTryCatch {
    public static void main(String[] args) {
        try {
            System.out.println("About to open a file");
            // Attempt to open the file "missingfile.txt"
            InputStream in = new FileInputStream("missingfile.txt");
            System.out.println("File open");
        } catch (Exception e) {
            // Catch any exception and print an error message
            System.out.println("Something went wrong!");
        }
    }
}
