package Lesson14.ex14_1_exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author oracle
 */
public class P03NioReadAll {
    
    public static void main(String[] args) {
        
        List<String> fileArr;
        Path file =  Paths.get("C:\\Users\\Chantel\\YourJavaDirectory\\hamlet.txt");

        try{
            // Read file into array here
            fileArr = Files.readAllLines(file);
            System.out.println("\n=== Rosencrantz ===");
            // Filter for Ros. here
            fileArr.stream()
                    .filter(line -> line.contains("Ros"))
                    .forEach(line -> System.out.println(line));
            
            System.out.println("\n=== Guildenstern ===");
            // Filter for Guil. here
            fileArr.stream()
                    .filter(line -> line.contains("Guild"))
                    .forEach(line -> System.out.println(line));

        }catch (IOException e){
          System.out.println("Error: " + e.getMessage());
        }
    } 
}
