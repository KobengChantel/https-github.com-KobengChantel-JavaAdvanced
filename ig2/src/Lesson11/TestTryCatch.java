package Lesson11;
import java.io.FileInputStream;
import java.io.InputStream;

public class TestTryCatch {
    public static void main(String[] args) {
        try{
            System.out.println("About to open file");
            //allows you to open files
            InputStream in = new FileInputStream("Missingfile");

        }
    }
}
