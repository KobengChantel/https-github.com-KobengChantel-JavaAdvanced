package Lesson14.ex14_2_exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Demonstrates walking the directory tree recursively using Files.walk()
 */
public class DirWalk {
  public static void main(String[] args) {

    // List all files and directories recursively
    try (Stream<Path> files = Files.walk(Paths.get("."))) {
      System.out.println("\n=== Dir walk ===");
      files.forEach(System.out::println);
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }

    // List files and directories recursively that contain "build" in their path
    try (Stream<Path> files = Files.walk(Paths.get("."))) {
      System.out.println("\n=== Dir build ===");
      files
              .filter(path -> path.toString().contains("build"))
              .forEach(System.out::println);
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
