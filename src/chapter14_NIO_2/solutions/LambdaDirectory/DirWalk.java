package chapter14_NIO_2.solutions.LambdaDirectory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 *
 * @author oracle
 */
public class DirWalk {
  public static void main(String[] args) {        
    try(Stream<Path> files = Files.walk(Paths.get("."))){

        System.out.println("\n=== Dir walk ===");
        files.forEach(line -> System.out.println(line));  

    }catch (IOException e){
        System.out.println("Error: " + e.getMessage());
    }

    try(Stream<Path> files = Files.walk(Paths.get("."))){

        System.out.println("\n=== Dir build ===");
        files
            .filter(path -> path.toString().contains("build"))
            .forEach(line -> System.out.println(line));  

    }catch (IOException e){
        System.out.println("Error: " + e.getMessage());
    }
  
  } 
}
