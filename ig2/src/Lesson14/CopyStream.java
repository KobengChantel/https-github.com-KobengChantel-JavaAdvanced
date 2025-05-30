package Lesson14;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

// program copies the content from a specified URI (local file or web resource) to a
// target file by opening an InputStream and writing it using the NIO Files.copy method,
// replacing the target file if it exists

public class
CopyStream {

    public static void main(String[] args) {
        // Check that there are at least two arguments (URL and output file)
        if (args.length < 2) {
            System.err.println("Usage: java CopyStream <URL> <file>");
            System.err.println("CopyStream copies a web page to a file.");
            System.exit(-1);
        }

        // Set the target output file path (hardcoded here)
        Path path = Paths.get("C:\\Users\\Chantel\\YourJavaDirectory\\Output.txt");

        // Create a URI for the source file (local file in this case)
        URI u = URI.create("C:\\Users\\Chantel\\YourJavaDirectory\\Input.txt");

        // Open an InputStream from the URI, then copy its contents to the target file,
        // replacing if exists
        try (InputStream in = u.toURL().openStream()) {
            Files.copy(in, path, REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println("Exception: " + e);
        }
    }
}
