package chapter14_NIO_2.practices.LambdaFiles_Pract01;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author oracle
 */
public class P04NioReadAll {
  public static void main(String[] args) {
        
    Path file =  Paths.get("hamlet.txt");
    List<String> fileArr;
/* Remove these comments
    try{
        // Read fileinto array here

        System.out.println("\n=== Lord Count ===");
        long wordCount = 0; // Replace with your pipeline
        
        System.out.println("Word count: " + wordCount);

        System.out.println("\n=== Prison Count ===");
        wordCount = 0; // Replace with your pipeline
        
        System.out.println("Word count: " + wordCount);            

    }catch (IOException e){
        System.out.println("Error: " + e.getMessage());
    }
*/
  } 
}
