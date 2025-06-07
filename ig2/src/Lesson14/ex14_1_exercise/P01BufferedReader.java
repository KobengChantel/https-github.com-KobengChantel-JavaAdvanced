package Lesson14.ex14_1_exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class demonstrates reading and printing the contents of a text file
 * using BufferedReader and FileReader. Each line from the file is printed
 * to the console.
 */
public class P01BufferedReader {

    public static void main(String[] args) {

        // Path to the input text file (update this if needed)
        String filePath = "C:\\Users\\Chantel\\YourJavaDirectory\\hamlet.txt";

        // Try-with-resources ensures BufferedReader is closed automatically
        try (BufferedReader bReader = new BufferedReader(new FileReader(filePath))) {

            System.out.println("=== Entire File ===");

            // Read and print each line using a stream
            bReader.lines().forEach(line -> System.out.println(line));

        } catch (IOException e) {
            // Print any I/O errors (e.g., file not found or unreadable)
            System.out.println("Error: " + e.getMessage());
        }
    }
}
