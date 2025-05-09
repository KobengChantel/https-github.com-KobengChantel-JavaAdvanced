package Lesson16;
import java.util.concurrent.ThreadLocalRandom;
public class SingleThreadTest {
    public static void main(String[] args) {
        int [] data = new int[1024*1024*128]; //512mb big

        //populates array with values
        for(int i=0; i < data.length; i++) {
            data[i] = ThreadLocalRandom.current().nextInt();

        }

        //min value = - 2147483648
        int max = Integer.MIN_VALUE;

        for(int value : data) {
            if(value > max) {
                max = value;
//                System.out.println(max + " ");
            }
        }
        System.out.println("Maxx value found: " + max);
    }
}
