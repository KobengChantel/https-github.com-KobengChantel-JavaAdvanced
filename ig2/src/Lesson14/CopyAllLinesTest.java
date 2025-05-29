package Lesson14;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import static java.nio.file.StandardOpenOption.*;

// program copies all lines from a source file to a target file, optionally allowing overwriting of the target file if specified with a command-line flag.

public class CopyAllLinesTest {

    private boolean overwrite = false; // Flag to allow overwriting target file
    private Path source = null;        // Path to source file
    private Path target = null;        // Path to target file

    public static void main(String[] args) {
        CopyAllLinesTest copy = new CopyAllLinesTest();
        copy.checkArguments(args);     // Validate input arguments
        try {
            copy.copyFile();           // Perform the file copy operation
        } catch (IOException i) {
            System.out.println("Exception thrown: " + i);
        }
        System.out.println ("Successfully copied!");
    }

    // Reads all lines from the source file and writes them to the target file
    private void copyFile() throws IOException {
        List<String> fileLines = null;
        Charset cs = Charset.defaultCharset();                // Use system default charset
        fileLines = Files.readAllLines(source, cs);           // Read all lines from source
        Files.write(target, fileLines, cs, CREATE, TRUNCATE_EXISTING, WRITE); // Write lines to target
    }

    // Validates and parses command-line arguments for source, target, and overwrite flag
    private void checkArguments(String args[]) {
        if (args.length < 2) {                                 // Need at least source and target
            System.out.println ("Not enough arguments.");
            usage();
        }
        if (args.length == 3) {                                // Optional overwrite flag present
            if (!args[0].equals("-o")) {
                System.out.println ("Check for the proper options.");
                usage();
            } else {
                overwrite = true;
                source = Paths.get(args[1]);
                target = Paths.get(args[2]);
            }
        } else {                                               // No overwrite flag; just source and target
            source = Paths.get(args[0]);
            target = Paths.get(args[1]);
        }
        if (Files.isDirectory(source)) {                       // Source must not be a directory
            System.out.println(source + " must be a file!");
            usage();
        }
        if (Files.exists(target) && !overwrite) {              // Target exists but no overwrite permission
            System.out.println("Target file " + target.getFileName() + " exists. Use the -o option to overwrite.");
            usage();
        }
    }

    // Prints usage info and terminates program
    private void usage() {
        System.out.println("Usage: CopyAllLinesTest {-o} <source file> <target file>");
        System.exit(-1);
    }
}
