package Lesson14.ex14_1_exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 * Reads a file into a list and counts occurrences of specific words.
 */
public class P04NioReadAll {
  public static void main(String[] args) {

    Path file = Paths.get("C:\\Users\\Chantel\\YourJavaDirectory\\hamlet.txt");
    List<String> fileArr;

    try {
      // Read entire file into List<String>
      fileArr = Files.readAllLines(file);

      System.out.println("\n=== Lord Count ===");
      long wordCount = fileArr.stream()
              // Split each line into words
              .flatMap(line -> Stream.of(line.split(" ")))
              // Filter words containing "lord" (case-sensitive)
              .filter(word -> word.contains("lord"))
              // Print each matched word
              .peek(System.out::println)
              // Count total matches
              .count();
      System.out.println("Word count: " + wordCount);

      System.out.println("\n=== Prison Count ===");
      wordCount = fileArr.stream()
              .flatMap(line -> Stream.of(line.split(" ")))
              .filter(word -> word.contains("prison"))
              .peek(System.out::println)
              .count();
      System.out.println("Word count: " + wordCount);

    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
