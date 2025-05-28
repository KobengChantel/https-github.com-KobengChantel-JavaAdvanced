package Lesson13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//program continuously reads user input from the keyboard, echoes each input line, and terminates when the user types "xyz"

public class KeyboardInput2 {

    public static void main(String[] args) {
        String s = ""; // Variable to hold user input

        // Try-with-resources to automatically close BufferedReader after use
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Type xyz to exit: ");

            // Read the first line of input
            s = in.readLine();

            // Continue reading until input is null (EOF)
            while (s != null) {
                // Print the trimmed input
                System.out.println("Read: " + s.trim());

                // Exit program if input equals "xyz"
                if (s.equals("xyz")) {
                    System.exit(0);
                }

                System.out.print("Type xyz to exit: ");
                // Read next line
                s = in.readLine();
            }
        } catch (IOException e) {
            // Handle any input/output exceptions
            System.out.println("Exception: " + e);
        }
    }
}