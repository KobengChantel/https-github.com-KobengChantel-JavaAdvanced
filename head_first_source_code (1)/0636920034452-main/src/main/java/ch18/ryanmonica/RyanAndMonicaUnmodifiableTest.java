package ch18.ryanmonica;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// This program simulates concurrent withdrawals from a shared account using ConcurrentHashMap, but race conditions still occur due to separate read and write operations.

public class RyanAndMonicaUnmodifiableTest {
  public static void main(String[] args) throws InterruptedException {
    long start = System.currentTimeMillis(); // Record the start time

    // Create a shared bank account collection
    BankAccountCollection account = new BankAccountCollection();

    // Create job tasks for Ryan and Monica
    RyanAndMonicaAccountsJob ryan = new RyanAndMonicaAccountsJob("Ryan", account);
    RyanAndMonicaAccountsJob monica = new RyanAndMonicaAccountsJob("Monica", account);

    // Run both jobs concurrently using two threads
    ExecutorService executor = Executors.newFixedThreadPool(2);
    executor.execute(ryan);
    executor.execute(monica);

    // Wait for both threads to complete
    executor.shutdown();
    executor.awaitTermination(1, TimeUnit.MINUTES);

    long end = System.currentTimeMillis(); // Record end time
    System.out.println(end - start);       // Print total runtime
    System.out.println(account.accountBalances); // Print final balances
  }
}

// Represents a job for a user trying to make 10 withdrawals from an account
class RyanAndMonicaAccountsJob implements Runnable {
  private final String name;
  private final BankAccountCollection account;
  private final String accountName = "checking"; // Operate only on checking account

  RyanAndMonicaAccountsJob(String name, BankAccountCollection account) {
    this.name = name;
    this.account = account;
  }

  public void run() {
    // Attempt to withdraw 10 units, 10 times
    for (int i = 0; i < 10; i++) {
      account.makeWithdrawal(10, accountName, name);
      if (account.getBalance(accountName) < 0) {
        System.out.println("Overdrawn!"); // Check for negative balance (race condition symptom)
      }
    }
  }
}

// Represents a collection of accounts using a ConcurrentHashMap
class BankAccountCollection {
  ConcurrentHashMap<String, Integer> accountBalances = new ConcurrentHashMap<>();

  // Initialize account balances
  {
    accountBalances.put("checking", 100);
    accountBalances.put("savings", 500);
    accountBalances.put("credit card", 1200);
  }

  // Retrieve the balance of a specific account
  public int getBalance(String accountName) {
    return accountBalances.get(accountName);
  }

  // Deduct amount from account (non-atomic if not called within a synchronized block)
  private void withdraw(int amount, String accountName) {
    accountBalances.computeIfPresent(accountName, (s, integer) -> integer - amount);
  }

  // Synchronized method to simulate withdrawal process
  public synchronized void makeWithdrawal(int amount, String accountName, String withdrawnBy) {
    final Integer balance = accountBalances.get(accountName);

    if (balance >= amount) {
      System.out.println(withdrawnBy + " is about to withdraw. balance: " + balance);
      try {
        System.out.println(withdrawnBy + " is going to sleep");
        Thread.sleep(500); // Simulate delay (increases chance of thread interference)
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
      System.out.println(withdrawnBy + " woke up.");
      withdraw(amount, accountName); // Perform the actual withdrawal
      System.out.println(withdrawnBy + " completes the withdrawal");
    } else {
      System.out.println("Sorry, not enough for " + withdrawnBy);
    }
  }
}
