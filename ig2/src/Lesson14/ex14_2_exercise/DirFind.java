package Lesson14.ex14_2_exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Finds and lists directories up to depth 9 starting from current directory.
 */
public class DirFind {

    public static void main(String[] args) {

        // Use try-with-resources to ensure the stream is closed properly
        try (Stream<Path> files = Files.find(
                Paths.get("."),    // start path: current directory
                9,                 // max depth
                (path, attr) -> attr.isDirectory() // filter to directories only
        )) {

            System.out.println("\n=== Find all dirs ===");
            files.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
