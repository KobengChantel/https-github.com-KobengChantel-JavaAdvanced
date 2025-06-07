package Lesson14.ex14_1_exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * This program reads all lines from a file into a list and filters lines containing specific keywords.
 */
public class P03NioReadAll {

    public static void main(String[] args) {

        // Declare a List to hold all lines from the file
        List<String> fileArr;
        // Define the path to the file
        Path file =  Paths.get("C:\\Users\\Chantel\\YourJavaDirectory\\hamlet.txt");

        try {
            // Read all lines from the file into a List of Strings
            fileArr = Files.readAllLines(file);

            System.out.println("\n=== Rosencrantz ===");
            // Filter and print lines that contain "Ros"
            fileArr.stream()
                    .filter(line -> line.contains("Ros"))
                    .forEach(line -> System.out.println(line));

            System.out.println("\n=== Guildenstern ===");
            // Filter and print lines that contain "Guild"
            fileArr.stream()
                    .filter(line -> line.contains("Guild"))
                    .forEach(line -> System.out.println(line));

        } catch (IOException e) {
            // Print error message if file reading fails
            System.out.println("Error: " + e.getMessage());
        }
    }
}
