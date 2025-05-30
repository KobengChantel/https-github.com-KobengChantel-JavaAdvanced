package Lesson15.ex15_1_exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

  public static void main(String[] args) {
    // Setup Executor
    ExecutorService es = Executors.newCachedThreadPool();
    CountRunnable run1 = new CountRunnable(20,"A");
    CountRunnable run2 = new CountRunnable(20,"B");
    CountRunnable run3 = new CountRunnable(20,"C");
    // Submit Runnable
    es.submit(run1);
    es.submit(run2);
    es.submit(run3);
    
    // Showndown ExectuorService
    es.shutdown();

  }
}
