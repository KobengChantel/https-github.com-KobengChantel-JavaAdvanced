package Lesson15;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger();
        //increment 5 once (6)
        System.out.println("New value: " + ai.incrementAndGet());

        //inceremnt 5 once (6)
        System.out.println("New value: " + ai.incrementAndGet());
//increment 5++ once more
        System.out.println(System.out.println("New value: " + ai.getAndIncrement());
);
    }
}
