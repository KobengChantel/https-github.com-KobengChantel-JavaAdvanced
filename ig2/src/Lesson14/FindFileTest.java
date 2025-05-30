package Lesson14;


import java.io.IOException;
import java.nio.file.*;

public class FindFileTest {

    public static void main(String[] args) {
//        if (args.length < 2) {
//            System.out.println("Usage: FindFileExample <start path> <search string>");
//            System.exit(-1);
//        }
        Path root = Paths.get("C:\\YourDirectory\\us_counties_housing_export.txt");
        if (!Files.isDirectory(root)) {
            System.out.println("Is a directory!");
            System.exit(-1);
        }

        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:" + "Input.txt");
        Finder finder = new Finder(root, matcher);
        try {
            Files.walkFileTree(root, finder);
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
        finder.done();
    }
}