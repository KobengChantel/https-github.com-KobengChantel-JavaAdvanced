package Lesson15;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CyclicBarrierExample {
    final CyclicBarrier barrier = new CyclicBarrier(2);
    AtomicInteger threadCount = new AtomicInteger(0);

    public static void main(String[] args) {
        //starting with 4 threads
        ExecutorService es = Executors.newFixedThreadPool(4);

        CyclicBarrierExample ex = new CyclicBarrierExample();
        es.submit(ex);

        es.shutdown();
    }
}
