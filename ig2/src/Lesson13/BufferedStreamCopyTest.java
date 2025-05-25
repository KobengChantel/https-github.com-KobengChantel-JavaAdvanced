package Lesson13;

import java.io.*;

public class BufferedStreamCopyTest {

    public static void main(String[] args) {
        // Test the arguments - there should be two
//        if (args.length < 2) {
//            System.out.println("Usage: java TestNodeStreams file1 file2\nBoth file names are required.");
//            System.exit(-1);
//        }
        //bufferedReader then File reader as both input and output(Chained streams)
        try (BufferedReader bufInput = new BufferedReader(new FileReader("C:\\Users\\Jada\\YourJavaDirectory\\Input.txt"));
             BufferedWriter bufOutput = new BufferedWriter(new FileWriter("C:\\Users\\Jada\\YourJavaDirectory\\BufferOutput.txt"))) {
            String line = "";
            // read the first line
            while ((line = bufInput.readLine()) != null) {
                // write the line out to the output file
                bufOutput.write(line);
                bufOutput.newLine();
            }
        } catch (FileNotFoundException f) {
            System.out.println("File not found: " + f);
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}