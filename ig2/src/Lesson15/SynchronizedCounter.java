package Lesson15;

public class SynchronizedCounter {
    private static int i = 0;

    public synchronized void increment(){
      i++;
    }

    public synchronized void decrement(){
        i--;
    }

    public synchronized int getValue(){
        return i;
    }
}
