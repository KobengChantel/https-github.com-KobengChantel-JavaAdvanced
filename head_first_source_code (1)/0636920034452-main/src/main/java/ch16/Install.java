package ch16;

import java.io.*;
import java.nio.file.*;

// This program creates a folder structure for an app and moves specified files into those folders using Java NIO file operations.

public class Install {
  public static void main(String[] args) {
    try {
      Path myPath = Paths.get("MyApp");                    // Path to main directory
      Path myPath2 = Paths.get("MyApp", "media");          // Path to media subdirectory
      Path myPath3 = Paths.get("MyApp", "source");         // Path to source subdirectory
      Path mySource = Paths.get("MyApp.class");            // Source file to move
      Path myMedia = Paths.get("MyMedia.jpeg");            // Media file to move

      Files.createDirectory(myPath);                        // Create main directory
      Files.createDirectory(myPath2);                       // Create media subdirectory
      Files.createDirectory(myPath3);                       // Create source subdirectory

      Files.move(mySource, myPath3.resolve(mySource.getFileName()));   // Move source file to source directory
      Files.move(myMedia, myPath2.resolve(myMedia.getFileName()));     // Move media file to media directory
    } catch (IOException e) {
      System.out.println("Got an NIO Exception" + e.getMessage());
    }
  }
}
