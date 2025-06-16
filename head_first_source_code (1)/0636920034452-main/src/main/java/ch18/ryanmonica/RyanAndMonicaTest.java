package ch18.ryanmonica;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// This program simulates two people spending money from a shared bank account without synchronization, demonstrating potential race conditions.

public class RyanAndMonicaTest {
  public static void main(String[] args) throws InterruptedException {
    // Run the scenario 10 times to check for concurrency issues
    for (int i = 0; i < 10; i++) {
      // Create a shared bank account with an initial balance of 100
      final BankAccount account = new BankAccount();

      // Create jobs for Ryan (spends 50) and Monica (spends 100)
      RyanAndMonicaJob ryan = new RyanAndMonicaJob("Ryan", account, 50);
      RyanAndMonicaJob monica = new RyanAndMonicaJob("Monica", account, 100);

      // Run both jobs in parallel using two threads
      ExecutorService executor = Executors.newFixedThreadPool(2);
      executor.execute(ryan);
      executor.execute(monica);

      // Shut down the executor and wait for both tasks to finish
      executor.shutdown();
      executor.awaitTermination(1, TimeUnit.MINUTES);

      // Print a separator between each test run
      System.out.println("---");
    }
  }
}

// Represents a task where a person tries to spend money
class RyanAndMonicaJob implements Runnable {
  private final String name;
  private final BankAccount account;
  private final int amountToSpend;

  RyanAndMonicaJob(String name, BankAccount account, int amountToSpend) {
    this.name = name;
    this.account = account;
    this.amountToSpend = amountToSpend;
  }

  public void run() {
    goShopping(amountToSpend);
  }

  // Attempts to spend the specified amount if sufficient balance is available
  private void goShopping(int amount) {
    if (account.getBalance() >= amount) {
      System.out.println(name + " is about to spend");
      account.spend(amount);
      System.out.println(name + " finishes spending");
    } else {
      System.out.println("Sorry, not enough for " + name);
    }
  }
}

// Represents the shared bank account (not thread-safe)
class BankAccount {
  private int balance = 100;  // Initial account balance

  // Returns the current balance
  public int getBalance() {
    return balance;
  }

  // Deducts the given amount from the balance
  public void spend(int amount) {
    balance = balance - amount;
    if (balance < 0) {
      System.out.println("Overdrawn!");
    }
  }
}
