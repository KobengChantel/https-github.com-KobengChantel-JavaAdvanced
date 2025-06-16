package ch18.exercise1;

// This class implements a runnable job that adds lowercase letters 'a' through 'z' to a shared data structure with a 50ms delay between each addition.

/**
 * A runnable job that adds lowercase letters from 'a' to 'z' to a shared data structure.
 * This class demonstrates potential thread safety issues when multiple threads access shared data.
 */
class AddLowerCaseJob implements Runnable {
  // Reference to the shared data structure that will store the letters
  private final IData data;

  /**
   * Constructor that initializes the job with a reference to the shared data structure.
   * @param data The shared data structure where letters will be added
   */
  AddLowerCaseJob(IData data) {
    this.data = data;
  }

  /**
   * The main execution method that runs when the thread starts.
   * Adds lowercase letters 'a' through 'z' to the shared data structure.
   */
  public void run() {
    // Starting character 'a' - will be incremented to add all lowercase letters
    char letter = 'a';

    // Loop through all 26 lowercase letters of the alphabet
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
    // WARNING: this can throw a ConcurrentModificationException if another thread
    // is modifying the collection while this thread is iterating over it
    System.out.println(Thread.currentThread().getName() + data.getLetters());

    // Print the current thread name and the size of the letters collection
    System.out.println(Thread.currentThread().getName() + " getLetters().size() = " + data.getLetters().size());
  }
}