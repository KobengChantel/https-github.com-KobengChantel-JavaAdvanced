/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * @author tmcginn
 */
public class ByteChannelCopyTest {

    // code copies a file’s entire byte content from an input file to an output file using Java NIO FileChannels and a ByteBuffer.

    public static void main(String[] args) {
//        if (args.length < 2) {
//            System.out.println("Usage: ByteChannelCopyTest <original file> <copy>");
//            System.exit(-1);
//        }
        // Open file channels for input and output files using FileInputStream and FileOutputStream
        try (FileChannel fcIn = new FileInputStream("C:\\Users\\Jada\\YourJavaDirectory\\Input.txt").getChannel();
             FileChannel fcOut = new FileOutputStream("C:\\Users\\Jada\\YourJavaDirectory\\ChannelOutput.txt").getChannel()) {
            // Print the size of the input file in bytes
            System.out.println("File size: " + fcIn.size());
            // Allocate a ByteBuffer with capacity equal to the input file size
            ByteBuffer buff = ByteBuffer.allocate((int) fcIn.size());
            // Show how many bytes the buffer can still accept (initially full capacity)
            System.out.println("Bytes remaining: " + buff.remaining());
            // Read bytes from the input channel into the buffer
            System.out.println ("Bytes read: " + fcIn.read(buff));
            // Reset buffer's position to 0 to prepare for writing
            buff.position(0);
            // Print buffer's state
            System.out.println ("Buffer: " + buff);
            // Show remaining bytes available in buffer for writing
            System.out.println("Bytes remaining: " + buff.remaining());
            // Write buffer content into the output channel and print bytes written
            System.out.println("Wrote: " + fcOut.write(buff) + "   bytes");
        } catch (FileNotFoundException f) {
            // Handle missing file scenario
            System.out.println("File not found: " + f);
        } catch (IOException e) {
            // Handle I/O errors
            System.out.println("IOException: " + e);
        }

    }
}

