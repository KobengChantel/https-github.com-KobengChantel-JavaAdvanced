package Lesson15;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);

        es.execute(new ExampleRunnable("One"));
        es.execute(new ExampleRunnable("Two"));
        //shuts threadd down
        es.shutdown();
    }
}
