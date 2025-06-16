package ch18.ryanmonica;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

// This program demonstrates atomic operations in concurrent programming where Ryan and Monica attempt to spend money from a shared bank account using AtomicInteger and compare-and-set operations.

/**
 * Test class that simulates concurrent spending from a shared bank account.
 * Runs 100 iterations to demonstrate atomic operations and race condition handling.
 */
public class RyanAndMonicaAtomicTest {
  /**
   * Main method that creates multiple test scenarios of concurrent spending.
   * @param args Command line arguments (not used)
   * @throws InterruptedException If thread execution is interrupted
   */
  public static void main(String[] args) throws InterruptedException {
    // Run 100 test iterations to observe different outcomes
    for (int i = 0; i < 100; i++) {
      // Create a new bank account with $100 balance for each test
      BankAccountWithAtomic account = new BankAccountWithAtomic();

      // Create Ryan who wants to spend $50
      RyanAndMonicaAtomicJob ryan = new RyanAndMonicaAtomicJob("Ryan", account, 50);

      // Create Monica who wants to spend $100
      RyanAndMonicaAtomicJob monica = new RyanAndMonicaAtomicJob("Monica", account, 100);

      // Create a thread pool with 2 threads to run both jobs concurrently
      ExecutorService executor = Executors.newFixedThreadPool(2);

      // Execute both spending jobs simultaneously
      executor.execute(ryan);
      executor.execute(monica);

      // Shutdown the executor and wait for completion
      executor.shutdown();
      executor.awaitTermination(1, TimeUnit.MINUTES);

      // Print separator between test iterations
      System.out.println("---");
    }
  }
}

/**
 * Runnable job that represents a person attempting to spend money from a shared account.
 * Each job has a name, access to the shared account, and an amount to spend.
 */
class RyanAndMonicaAtomicJob implements Runnable {
  // The name of the person (Ryan or Monica)
  private final String name;

  // Reference to the shared bank account
  private final BankAccountWithAtomic account;

  // The amount this person wants to spend
  private final int amountToSpend;

  /**
   * Constructor to initialize the spending job.
   * @param name The name of the person
   * @param account The shared bank account
   * @param amountToSpend The amount this person wants to spend
   */
  RyanAndMonicaAtomicJob(String name, BankAccountWithAtomic account, int amountToSpend) {
    this.name = name;
    this.account = account;
    this.amountToSpend = amountToSpend;
  }

  /**
   * The main execution method that runs when the thread starts.
   * Calls the shopping method with the predetermined amount.
   */
  public void run() {
    goShopping(amountToSpend);
  }

  /**
   * Simulates the shopping process by attempting to spend the specified amount.
   * @param amount The amount to spend
   */
  private void goShopping(int amount) {
    System.out.println(name + " is about to spend");

    // Attempt to spend the money using the atomic account operations
    account.spend(name, amount);

    System.out.println(name + " finishes spending");
  }
}

/**
 * Thread-safe bank account implementation using AtomicInteger.
 * Uses compare-and-set operations to handle concurrent spending attempts safely.
 */
class BankAccountWithAtomic {
  // AtomicInteger provides thread-safe operations without explicit synchronization
  // Initial balance is $100
  private final AtomicInteger balance = new AtomicInteger(100);

  /**
   * Attempts to spend money from the account using atomic compare-and-set operation.
   * This method handles race conditions by using atomic operations instead of locks.
   * @param name The name of the person attempting to spend
   * @param amount The amount to spend
   */
  public void spend(String name, int amount) {
    // Get the current balance atomically
    int initialBalance = balance.get();

    // Check if there's enough money to spend
    if (initialBalance >= amount) {
      // Attempt to update the balance atomically using compare-and-set
      // This will only succeed if the balance hasn't changed since we read it
      boolean success = balance.compareAndSet(initialBalance, initialBalance - amount);

      // If the compare-and-set failed, another thread modified the balance
      if (!success) {
        System.out.println("Sorry " + name + ", you haven't spent the money.");
      }
      // If success is true, the money was successfully spent (no output for success case)
    } else {
      // Not enough money in the account
      System.out.println("Sorry, not enough for " + name);
    }
  }
}