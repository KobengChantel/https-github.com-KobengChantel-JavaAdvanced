//package Lesson15;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executor;
//
//
//public class AtomicTest{
//    public static void main(String[] args) {
//        ExecutorService es = new Executor.newFixedThreadPool(4);
//
//    //multiple threads
//        es.submit(new AtomicCounterRunnable(10, "A"));
//        es.submit(new AtomicCounterRunnable(10, "B"));
//        es.submit(new AtomicCounterRunnable(10, "C"));
//
//        es.shutdown();
//    }
//}
