// Source code is decompiled from a .class file using FernFlower decompiler.
package Lesson13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//program repeatedly reads lines typed by the user from the keyboard, echoes them back, and terminates when the user types "xyz"

public class KeyboardInput {
    // Default constructor (not used here)
    public KeyboardInput() {
    }

    public static void main(String[] var0) {
        String var1 = ""; // Variable to store user input

        try {
            // Create BufferedReader to read text from standard input (keyboard)
            BufferedReader var2 = new BufferedReader(new InputStreamReader(System.in));

            try {
                System.out.print("Type xyz to exit: ");

                // Read lines from keyboard until user inputs "xyz" or EOF
                for (var1 = var2.readLine(); var1 != null; var1 = var2.readLine()) {
                    // Print trimmed input back to the console
                    System.out.println("Read: " + var1.trim());

                    // Exit program if user types "xyz"
                    if (var1.equals("xyz")) {
                        System.exit(0);
                    }

                    System.out.print("Type xyz to exit: ");
                }
            } catch (Throwable var6) {
                // Ensure the BufferedReader is closed if an exception occurs
                try {
                    var2.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }
                throw var6;
            }

            // Close the BufferedReader after use
            var2.close();
        } catch (IOException var7) {
            // Handle input/output exceptions
            System.out.println("Exception: " + var7);
        }
    }
}