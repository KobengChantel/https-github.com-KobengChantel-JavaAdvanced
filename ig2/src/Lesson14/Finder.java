package Lesson14;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import static java.nio.file.FileVisitResult.CONTINUE;

//class recursively visits files and directories, using a PathMatcher to identify and count those that match a specified pattern, printing each match as it's found.


/**
 * This class is a custom file visitor used to find and match files or directories
 * based on a given pattern using a PathMatcher.
 */
public class Finder extends SimpleFileVisitor<Path> {

    private Path file;               // Path to search (not used in logic but typically provided)
    private PathMatcher matcher;     // Matcher to apply glob or regex pattern
    private int numMatches;          // Counter for matched files/directories

    // Constructor takes a path and a matcher
    public Finder(Path file, PathMatcher matcher) {
        this.file = file;
        this.matcher = matcher;
    }

    // Compares the glob or regex pattern against the current file or directory name
    private void find(Path file) {
        Path name = file.getFileName(); // Get the file or directory name
        if (name != null && matcher.matches(name)) { // Check if it matches
            numMatches++; // Increment match counter
            System.out.println(file); // Print the matching file path
        }
    }

    // Prints the total number of matching files/directories found
    public void done() {
        System.out.println("Matched: " + numMatches);
    }

    // Called when a file is visited; invokes the matching logic
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        find(file);
        return CONTINUE; // Continue to next file
    }

    // Called when a directory is visited; invokes the matching logic
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        find(dir);
        return CONTINUE; // Continue to next directory
    }
}