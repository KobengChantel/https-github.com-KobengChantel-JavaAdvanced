package Lesson14.ex14_1_exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * This class demonstrates reading a file line-by-line using Java NIO's Files.lines()
 * method with try-with-resources to automatically close the stream.
 */
public class P02NioRead {

    public static void main(String[] args) {

        // Path to the file
        String filePath = "C:\\Users\\Chantel\\YourJavaDirectory\\hamlet.txt";

        // Try-with-resources to automatically close the Stream<String> after use
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {

            System.out.println("\n=== Entire File ===");

            // Print each line of the file
            lines.forEach(line -> System.out.println(line));

        } catch (IOException e) {
            // Handle exceptions like file not found or access issues
            System.out.println("Error: " + e.getMessage());
        }
    }
}
