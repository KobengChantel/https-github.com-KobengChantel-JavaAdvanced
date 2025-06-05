package Lesson15;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Demonstrates the use of CopyOnWriteArrayList in a multithreaded context.
 * demonstrate how a thread-safe CopyOnWriteArrayList can be safely modified by multiple threads
 * concurrently using a shared Runnable instance.
 */
public class ArrayListTest implements Runnable {
    // Thread-safe list used to store words
    private CopyOnWriteArrayList<String> wordList = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        // Create a thread pool that can dynamically reuse threads
        ExecutorService es = Executors.newCachedThreadPool();

        // Create a shared instance of ArrayListTest
        ArrayListTest test = new ArrayListTest();

        // Submit the same task twice to the executor for execution
        es.submit(test);
        es.submit(test);

        // Shutdown the executor - no new tasks will be accepted
        es.shutdown();

        // Print the contents of the word list
        System.out.println("==ItemList==");
        test.getArrayList().stream().forEach(s -> System.out.println("Item: " + s));
    }

    /**
     * Task to be executed by the thread pool.
     * Adds three strings to the wordList.
     */
    public void run() {
        wordList.add("A");
        wordList.add("B");
        wordList.add("C");
    }

    /**
     * Getter for the word list.
     * @return the thread-safe word list
     */
    public CopyOnWriteArrayList<String> getArrayList() {
        return wordList;
    }
}
