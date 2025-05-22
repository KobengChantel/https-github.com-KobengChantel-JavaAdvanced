package Lesson15;

public class ThreadTest {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ExampleRunnable("one"));
        ExampleThread thread2 = new ExampleThread("two");

        //start Threads
        thread1.start();
        thread2.start();
    }
    //static classes, variables and methods
    //stored in memory, are global and can't be deleted
    //don't have to be instatiated
    //can't lock statis fields so don't use in threads
}
