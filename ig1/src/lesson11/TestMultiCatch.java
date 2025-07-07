package lesson11;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

// This program demonstrates handling multiple exceptions (NoSuchElementException and IOException) using a multi-catch block while reading from a file.

public class TestMultiCatch {

    public static void main(String[] args) {
        System.out.println("About to open a file");

        // Try-with-resources to automatically close InputStream and Scanner
        try (InputStream in = new FileInputStream("missingfile.tx");
             Scanner s = new Scanner(in);) {

            System.out.println("File open");
            // Attempt to read an integer from the file
            int data = s.nextInt();

        } catch (NoSuchElementException | IOException e) {
            // Catch either NoSuchElementException (if no int is found) or IOException (file missing or IO error)
            System.out.println(e.getClass().getName());
            System.out.println("Quiting");
        }
    }
}
