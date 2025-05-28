package Lesson13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//program reads bytes from a source file and writes them to a target file, effectively copying the file contents using byte streams in Java.

public class ByteStreamCopyTest {

    // This program copies the contents of one file to another using byte streams.
    public static void main(String[] args) {
//        if (args.length < 2) {
//            //copies one file to another
//            System.out.println ("Usage: ByteStreamCopyTest <original file> <copy>");
//            System.exit(-1);
//        }
        // Buffer to temporarily hold bytes read from the input file
        byte[] b = new byte[128];

        // Try-with-resources to automatically close streams after use
        try (FileInputStream fis = new FileInputStream("C:\\Users\\Jada\\YourJavaDirectory\\Input.txt");
             FileOutputStream fos = new FileOutputStream("C:\\Users\\Jada\\YourJavaDirectory\\ByteOutput.txt")) {

            // Print number of bytes available to read from the input file
            System.out.println("Bytes available: " + fis.available());

            int count = 0; // Count total bytes copied
            int read = 0;  // Number of bytes read in each iteration

            // Read bytes into buffer until end of file (-1)
            while ((read = fis.read(b)) != -1) {
                // Write all bytes from buffer to output file
                fos.write(b);
                // Increment total count by number of bytes read
                count += read;
            }

            // Print total number of bytes written
            System.out.println("Wrote: " + count);

        } catch (FileNotFoundException f) {
            // Handle file not found exception
            System.out.println("File not found: " + f);
        } catch (IOException e) {
            // Handle input/output exceptions
            System.out.println("IOException: " + e);
        }
    }
}
