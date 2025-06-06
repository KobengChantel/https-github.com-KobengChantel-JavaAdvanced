package Lesson14.ex14_2_exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Lists files and directories in the current directory (non-recursive).
 */
public class DirList {
  public static void main(String[] args) {
    try (Stream<Path> files = Files.list(Paths.get("."))) {
      System.out.println("\n=== Dir list ===");
      files.forEach(System.out::println);
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
