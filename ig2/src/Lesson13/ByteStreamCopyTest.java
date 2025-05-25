package Lesson13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamCopyTest {

    public static void main(String[] args) {
//        if (args.length < 2) {
//            //copies one file to another
//            System.out.println ("Usage: ByteStreamCopyTest <original file> <copy>");
//            System.exit(-1);
//        }
        byte[] b = new byte[128];
        // Example use of InputStream methods
        try (FileInputStream fis = new FileInputStream ("C:\\Users\\Jada\\YourJavaDirectory\\Input.txt");
             //automatically creates file if doesn't exist
             FileOutputStream fos = new FileOutputStream ("C:\\Users\\Jada\\YourJavaDirectory\\ByteOutput.txt")) {
            System.out.println ("Bytes available: " + fis.available());
            int count = 0; int read = 0;
            //once the copying has ended while loop ends

            while ((read = fis.read(b)) != -1) {
                fos.write(b);
                //counts no. of characters
                count += read;
            }
            System.out.println ("Wrote: " + count);
        } catch (FileNotFoundException f) {
            System.out.println ("File not found: " + f);
        } catch (IOException e) {
            System.out.println ("IOException: " + e);
        }
    }
}


