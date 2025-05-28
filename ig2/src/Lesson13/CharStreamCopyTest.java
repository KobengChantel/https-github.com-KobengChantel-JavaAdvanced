package Lesson13;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamCopyTest {

    // This program copies the contents of one text file to another using character streams.
    public static void main(String[] args) {
        // Buffer to temporarily hold characters read from the input file
        char[] c = new char[128];

        // Try-with-resources ensures streams are closed automatically
        try (FileReader fr = new FileReader("C:\\Users\\Jada\\YourJavaDirectory\\Input.txt");
             FileWriter fw = new FileWriter("C:\\Users\\Jada\\YourJavaDirectory\\CharOutput.txt")) {

            int count = 0; // Count total characters copied
            int read = 0;  // Number of characters read in each iteration

            // Read characters into buffer until end of file (-1)
            while ((read = fr.read(c)) != -1) {
                // Write all characters from buffer to output file
                fw.write(c);
                // Increment total count by number of characters read
                count += read;
            }

            // Print total number of characters written
            System.out.println("Wrote: " + count + " characters.");

        } catch (FileNotFoundException f) {
            // Handle case where input file is missing
            System.out.println("File " + (args.length > 0 ? args[0] : "") + " not found.");
        } catch (IOException e) {
            // Handle other input/output exceptions
            System.out.println("IOException: " + e);
        }
    }
}