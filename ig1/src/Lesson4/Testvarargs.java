package Lesson4;

public class Testvarargs {
    public static void main(String[] args) {
        float total = Statistics.avg(4, 200, 68, 7);
        //can pass nothing because method has varargs
        //due to result being 0 by default, it'll return 0 instead of error
        //if nothing is passed
        float total2 = Statistics.avg();
        System.out.println(total);
        System.out.println(total2);
    }
}
