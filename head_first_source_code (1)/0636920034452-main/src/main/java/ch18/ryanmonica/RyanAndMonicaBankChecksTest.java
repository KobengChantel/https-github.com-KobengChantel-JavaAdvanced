package ch18.ryanmonica;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// This program simulates two people (Ryan and Monica) spending from a shared bank account using threads, testing for race conditions and thread safety.

/**
 * code demonstrates multithreaded access to a shared bank account using synchronized methods to prevent inconsistent balance updates when multiple threads (Ryan and Monica) try to spend money concurrently.
 */
public class RyanAndMonicaBankChecksTest {
  public static void main(String[] args) throws InterruptedException {
    // Run the scenario 10 times to expose possible synchronization issues
    for (int i = 0; i < 10; i++) {
      // Create a new bank account with a starting balance of 100
      BankAccountChecks account = new BankAccountChecks();

      // Create two spending jobs: Ryan wants to spend 50, Monica wants to spend 100
      RyanAndMonicaBankChecksJob ryan = new RyanAndMonicaBankChecksJob("Ryan", account, 50);
      RyanAndMonicaBankChecksJob monica = new RyanAndMonicaBankChecksJob("Monica", account, 100);

      // Use an ExecutorService with 2 threads to run the jobs concurrently
      ExecutorService executor = Executors.newFixedThreadPool(2);
      executor.execute(ryan);   // Submit Ryan's job
      executor.execute(monica); // Submit Monica's job

      // Initiate shutdown and wait for both jobs to finish
      executor.shutdown();
      executor.awaitTermination(1, TimeUnit.MINUTES);

      // Print a separator after each iteration
      System.out.println("---");
    }
  }
}

// Runnable job representing a person attempting to spend money
class RyanAndMonicaBankChecksJob implements Runnable {
  private final String name;
  private final BankAccountChecks account;
  private final int amountToSpend;

  // Constructor assigns person name, account reference, and spending amount
  RyanAndMonicaBankChecksJob(String name, BankAccountChecks account, int amountToSpend) {
    this.name = name;
    this.account = account;
    this.amountToSpend = amountToSpend;
  }

  // Run method that simulates the shopping process
  public void run() {
    goShopping(amountToSpend);
  }

  // Simulates the act of going shopping and spending money from the account
  private void goShopping(int amount) {
    System.out.println(name + " is about to spend");
    account.spend(name, amount); // Attempt to spend from the account
    System.out.println(name + " finishes spending");
  }
}

// Shared bank account class
class BankAccountChecks {
  private int balance = 100; // Starting balance

  public int getBalance() {
    return balance;
  }

  // Spend method synchronized to prevent race conditions
  public synchronized void spend(String name, int amount) {
    // Check if enough balance is available
    if (getBalance() >= amount) {
      balance = balance - amount; // Deduct amount
      if (balance < 0) {
        System.out.println("Overdrawn!"); // Defensive check
      }
    } else {
      System.out.println("Sorry, not enough for " + name); // Insufficient funds
    }
  }
}
