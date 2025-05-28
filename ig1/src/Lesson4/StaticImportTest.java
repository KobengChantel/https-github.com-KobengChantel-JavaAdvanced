package Lesson4;

import static java.lang.Math.*;
public class StaticImportTest {
    public static void main(String[] args) {
        //don't need to call Math class
        System.out.println("Random: " + random() * 200);
        System.out.println("Square Root: " + sqrt(25.0));
        System.out.println("Rounded random: " + round(random() * 200));
        System.out.println("Absolute: " + abs(-22));
    }
}
