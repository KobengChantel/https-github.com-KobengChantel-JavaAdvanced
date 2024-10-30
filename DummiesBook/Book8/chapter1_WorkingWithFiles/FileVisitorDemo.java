package DummiesBook.Book8.chapter1_WorkingWithFiles;

// Listing 1.1
import java.nio.file.*;
import java.io.*;
import java.nio.file.attribute.*;

public class FileVisitorDemo {
    public static void main(String[] args) {
        // Specify the starting path for the file tree traversal
        Path start = Paths.get("C:\\Windows\\System32"); // Ensure correct path format
        MyFileVisitor visitor = new MyFileVisitor();
        try {
            // Walk through the file tree starting at the specified path
            Files.walkFileTree(start, visitor);
        } catch (Exception e) {
            // Handle exceptions that occur during file traversal
            System.out.println(e.getMessage());
        }
    }

    // Custom file visitor that extends SimpleFileVisitor
    private static class MyFileVisitor extends SimpleFileVisitor<Path> {
        // This method is called for each file visited
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
            // Print the file's path
            System.out.println(file.toString());
            return FileVisitResult.CONTINUE; // Continue visiting other files
        }

        // This method is called when a file cannot be accessed
        @Override
        public FileVisitResult visitFileFailed(Path file, IOException e) {
            // Print an error message for the inaccessible file
            System.out.println(file.toString() + " COULD NOT ACCESS!");
            return FileVisitResult.CONTINUE; // Continue visiting other files
        }

        // This method is called before visiting a directory
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            // Print the directory's path
            System.out.println("Entering directory: " + dir.toString());
            return FileVisitResult.CONTINUE; // Continue visiting the directory
        }

        // This method is called when a directory cannot be accessed
        @Override
        public FileVisitResult preVisitDirectoryFailed(Path dir, IOException e) {
            // Print an error message for the inaccessible directory
            System.out.println(dir.toString() + " COULD NOT ACCESS!");
            return FileVisitResult.CONTINUE; // Continue visiting other directories
        }
    }
}
