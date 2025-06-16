package ch18.exercise1;

// This class implements a runnable job that adds uppercase letters 'A' through 'Z' to a shared data structure with a 50ms delay between each addition.

/**
 * A runnable job that adds uppercase letters from 'A' to 'Z' to a shared data structure.
 * This class demonstrates potential thread safety issues when multiple threads access shared data.
 */
class AddUpperCaseJob implements Runnable {
  // Reference to the shared data structure that will store the letters
  private final IData data;

  /**
   * Constructor that initializes the job with a reference to the shared data structure.
   * @param data The shared data structure where letters will be added
   */
  AddUpperCaseJob(IData data) {
    this.data = data;
  }

  /**
   * The main execution method that runs when the thread starts.
   * Adds uppercase letters 'A' through 'Z' to the shared data structure.
   */
  public void run() {
    // Starting character 'A' - will be incremented to add all uppercase letters
    char letter = 'A';

    // Loop through all 26 uppercase letters of the alphabet
    for (int i = 0; i < 26; i++) {
      // Add the current letter to the shared data structure and increment to next letter
      data.addLetter(letter++);

      try {
        // Sleep for 50 milliseconds to simulate some processing time
        // This also increases the likelihood of thread interference
        Thread.sleep(50);
      } catch (InterruptedException ignored) {
        // Ignore interruption exceptions - thread will continue execution
      }
    }

    // Print the current thread name and all letters in the data structure
    // This can throw a ConcurrentModificationException if another thread
    // is modifying the collection while this thread is iterating over it
    System.out.println(Thread.currentThread().getName() + data.getLetters());

    // Print the current thread name and the size of the letters collection
    System.out.println(Thread.currentThread().getName() + " getLetters().size() = " + data.getLetters().size());
  }
}