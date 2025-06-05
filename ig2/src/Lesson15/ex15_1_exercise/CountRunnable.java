package Lesson15.ex15_1_exercise;

// This class defines a Runnable that counts from 1 up to a
// specified number and prints each value along with the thread's name.

public class CountRunnable implements Runnable {

  // Number to count up to
  final int count;

  // Name identifier for the thread
  final String threadName;

  // Constructor to initialize the count limit and thread name
  public CountRunnable(int count, String threadName) {
    this.count = count;
    this.threadName = threadName;
  }

  @Override
  public void run() {
    // Count from 1 to 'count' and print each value with the thread's name
    for (int i = 1; i <= count; i++) {
      System.out.println("Thread " + threadName + ": " + i);
    }
  }
}
