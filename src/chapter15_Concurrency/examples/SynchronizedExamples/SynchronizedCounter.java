package chapter15_Concurrency.examples.SynchronizedExamples;

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
