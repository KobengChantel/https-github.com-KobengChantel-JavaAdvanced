package Lesson14.ex14_1_exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author oracle
 */
public class P01BufferedReader {
    
    public static void main(String[] args) {
        
        try{
            BufferedReader bReader = 
                new BufferedReader(new FileReader("C:\\Users\\Chantel\\YourJavaDirectory\\hamlet.txt"));
            System.out.println("=== Entire File ===");
            
            bReader.lines()
                   .forEach(lines -> System.out.println(lines));
                        
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    } 
}
