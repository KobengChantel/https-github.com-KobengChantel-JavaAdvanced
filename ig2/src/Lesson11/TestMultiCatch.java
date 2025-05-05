package Lesson11;
import java.io.FileInputStream;
import java.io.InputStream;

public class TestMultiCatch {
    public static void main(String[] args) {
        System.out.println("about to open file");
        try(InputStream in = new FileInputStream("missing file");
            Scanner s = new Scanner(in)
    }
}
