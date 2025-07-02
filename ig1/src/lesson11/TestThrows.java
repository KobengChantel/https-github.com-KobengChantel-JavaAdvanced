package lesson11;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestThrows {

    public static void main(String[] args) {
        try {
            int data = readByteFromFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //throws is used in method declaration
    public static int readByteFromFile() throws IOException {
        try (InputStream in = new FileInputStream("a.txt")) {
            System.out.println("File open");
            return in.read();
        }
    }
}