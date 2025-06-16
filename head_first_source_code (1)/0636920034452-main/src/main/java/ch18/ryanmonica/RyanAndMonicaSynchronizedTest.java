package ch18.ryanmonica;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// This program simulates two people accessing a shared bank account concurrently, using synchronized blocks to prevent race conditions.

public class RyanAndMonicaSynchronizedTest {
  public static void main(String[] args) throws InterruptedException {
    // Run the scenario 10 times to test for synchronization reliability
    for (int i = 0; i < 10; i++) {
      // Create a new bank account with a balance of 100
      BankAccountSynchronized account = new BankAccountSynchronized();

      // Create jobs for Ryan (spending 50) and Monica (spending 100)
      RyanAndMonicaSynchronizedJob ryan = new RyanAndMonicaSynchronizedJob("Ryan", account, 50);
      RyanAndMonicaSynchronizedJob monica = new RyanAndMonicaSynchronizedJob("Monica", account, 100);

      // Run both jobs concurrently using a thread pool
      ExecutorService executor = Executors.newFixedThreadPool(2);
      executor.execute(ryan);
      executor.execute(monica);

      // Shut down the executor and wait for the tasks to complete
      executor.shutdown();
      executor.awaitTermination(1, TimeUnit.MINUTES);

      // Print a separator between test runs
      System.out.println("---");
    }
  }
}

// A Runnable job representing a person trying to spend money
class RyanAndMonicaSynchronizedJob implements Runnable {
  private final String name;
  private final BankAccountSynchronized account;
  private final int amountToSpend;

  RyanAndMonicaSynchronizedJob(String name, BankAccountSynchronized account, int amountToSpend) {
    this.name = name;
    this.account = account;
    this.amountToSpend = amountToSpend;
  }

  public void run() {
    goShopping(amountToSpend);
  }

  // Synchronized block ensures only one thread can spend from the account at a time
  private void goShopping(int amount) {
    synchronized (account) {
      if (account.getBalance() >= amount) {
        System.out.println(name + " is about to spend");
        account.spend(amount);
        System.out.println(name + " finishes spending");
      } else {
        System.out.println("Sorry, not enough for " + name);
      }
    }
  }
}

// Shared bank account with balance operations
class BankAccountSynchronized {
  private int balance = 100; // Initial balance

  // Returns current balance
  public int getBalance() {
    return balance;
  }

  // Deducts amount from balance
  public void spend(int amount) {
    balance = balance - amount;
    if (balance < 0) {
      System.out.println("Overdrawn!"); // Defensive check
    }
  }
}
