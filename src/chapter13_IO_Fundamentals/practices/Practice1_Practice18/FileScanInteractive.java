package chapter13_IO_Fundamentals.practices.Practice1_Practice18;
//filescanner13-01practice
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileScanInteractive {

    public int countTokens(String file, String search) throws IOException {
        int instanceCount = 0;
        try (FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                Scanner s = new Scanner(br)) {
            s.useDelimiter("\\W");
            while (s.hasNext()) {
                if (search.equalsIgnoreCase(s.next().trim())) {
                    instanceCount++;
                }
            }
        } // try-with-resources will close the connections
        return instanceCount;
    }

    public static void main(String[] args) {
        // Your code goes here
    }
}