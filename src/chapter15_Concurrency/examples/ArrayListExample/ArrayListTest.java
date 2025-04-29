package chapter15_Concurrency.examples.ArrayListExample;
// Import necessary classes for thread-safe list and concurrent execution
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Define the ArrayListTest class which implements Runnable(interface) to run in multiple threads
public class ArrayListTest implements Runnable {

  // Declare a thread-safe CopyOnWriteArrayList to hold strings
  private CopyOnWriteArrayList<String> wordList = new CopyOnWriteArrayList<>();

  // Main method to execute the program
  public static void main(String[] args) {

    // Create a cached thread pool to manage threads dynamically
    ExecutorService es = Executors.newCachedThreadPool();

    // Create an instance of ArrayListTest, which implements Runnable
    ArrayListTest test = new ArrayListTest();

    // Submit the test instance as a task to be executed by two threads
    es.submit(test);  // Submit the first task
    es.submit(test);  // Submit the second task

    // Shutdown the ExecutorService after submitting tasks (no more tasks can be submitted)
    es.shutdown();

    // Print a header for the list of items
    System.out.println("==ItemList==");

    // Get the wordList and print each item using a stream
    test.getArrayList().stream().forEach(
            s -> System.out.println("Item: " + s));  // Print each item in the list
  }

  // The run method that will be executed by each thread
  public void run(){
    // Add strings to the wordList in each thread
    wordList.add("A");
    wordList.add("B");
    wordList.add("C");
  }

  // Method to return the wordList
  public CopyOnWriteArrayList<String> getArrayList(){
    return wordList;  // Return the thread-safe list
  }
}
