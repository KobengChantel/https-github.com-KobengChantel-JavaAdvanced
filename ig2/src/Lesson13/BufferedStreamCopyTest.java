package Lesson13;

import java.io.*;

//code copies the contents of a text file line by line from an input file to an output file using buffered character streams.

public class BufferedStreamCopyTest {

    public static void main(String[] args) {
        // BufferedReader reads text from the input file line by line
        // BufferedWriter writes text to the output file line by line
        try (BufferedReader bufInput = new BufferedReader(new FileReader("C:\\Users\\Jada\\YourJavaDirectory\\Input.txt"));
             BufferedWriter bufOutput = new BufferedWriter(new FileWriter("C:\\Users\\Jada\\YourJavaDirectory\\BufferOutput.txt"))) {
            String line = "";
            // Read each line from input file until end of file
            while ((line = bufInput.readLine()) != null) {
                // Write the read line to the output file
                bufOutput.write(line);
                // Insert a new line in the output file
                bufOutput.newLine();
            }
        } catch (FileNotFoundException f) {
            // Handle case when input file is missing
            System.out.println("File not found: " + f);
        } catch (IOException e) {
            // Handle other I/O exceptions
            System.out.println("Exception: " + e);
        }
    }
}
