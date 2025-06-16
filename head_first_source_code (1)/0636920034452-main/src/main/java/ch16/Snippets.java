package ch16;

import java.io.*;

// This class demonstrates listing the contents of a directory and splitting a string by a delimiter.

public class Snippets {
  // Lists and prints all filenames and directory names inside the given directory
  void listDirectory(File dir) {
    if (dir.isDirectory()) {
      String[] dirContents = dir.list();
      for (String dirContent : dirContents) {
        System.out.println(dirContent);
      }
    }
  }

  // Splits a string by the "/" character and prints each part separately
  void testSplit() {
    String toTest = "What is blue + yellow?/green";
    String[] result = toTest.split("/");
    for (String token : result) {
      System.out.println(token);
    }
  }
}
