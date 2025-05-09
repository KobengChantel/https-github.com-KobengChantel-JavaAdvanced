package Lesson15;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    public static void main(String[] args) {

        AtomicInteger ai = new AtomicInteger();

        //increment 5 once (6)
        System.out.println("New value: " + ai.incrementAndGet());

        //inceremnt 5 once (6)
        System.out.println("New value: " + ai.getAndIncrement());

        //increment 5++ once more (7)
        System.out.println("New value: " + ai.getAndIncrement());

    }
}
