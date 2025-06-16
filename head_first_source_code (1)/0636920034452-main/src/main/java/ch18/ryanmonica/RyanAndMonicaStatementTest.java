package ch18.ryanmonica;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// This program simulates multiple users spending from a shared bank account and reading the transaction history concurrently using thread-safe data structures.

public class RyanAndMonicaStatementTest {
  public static void main(String[] args) throws InterruptedException {
    // Create a shared bank account with an initial statement
    BankAccountStatement account = new BankAccountStatement();

    // Create a thread pool with 4 threads
    ExecutorService executor = Executors.newFixedThreadPool(4);

    // Repeat 5 times: Ryan spends while Monica, an Accountant, and a Bank Manager read the transaction history
    for (int i = 0; i < 5; i++) {
      executor.execute(new RyanAndMonicaStatementJob("Ryan", account, 20));         // Ryan spends money
      executor.execute(new StatementReader("Monica", account));                     // Monica reads statement
      executor.execute(new StatementReader("Accountant", account));                 // Accountant reads statement
      executor.execute(new StatementReader("Bank Manager", account));               // Bank Manager reads statement
    }

    // Gracefully shut down the executor after submitting all tasks
    executor.shutdown();
  }
}

// Represents a job where a person tries to spend money from the account
class RyanAndMonicaStatementJob implements Runnable {
  private final String name;
  private final BankAccountStatement account;
  private final int amountToSpend;

  RyanAndMonicaStatementJob(String name, BankAccountStatement account, int amountToSpend) {
    this.name = name;
    this.account = account;
    this.amountToSpend = amountToSpend;
  }

  public void run() {
    // Check if there is enough balance, then spend and log transaction
    if (account.getBalance() >= amountToSpend) {
      account.spend(amountToSpend, name);
      System.out.println(name + " finishes spending");
    } else {
      System.out.println("Sorry, not enough for " + name);
    }
  }
}

// Represents a user reading all transactions from the statement
class StatementReader implements Runnable {
  private final String name;
  private final BankAccountStatement account;

  StatementReader(String name, BankAccountStatement account) {
    this.name = name;
    this.account = account;
  }

  @Override
  public void run() {
    // Print each transaction read from the shared statement
    for (Transaction transaction : account.getStatement()) {
      System.out.println(name + " read " + transaction);
    }
  }
}

// Bank account that maintains a transaction history using a thread-safe list
class BankAccountStatement {
  private final List<Transaction> statement = new CopyOnWriteArrayList<>();

  // Initialize with an opening balance
  public BankAccountStatement() {
    statement.add(new Transaction("Initial Balance", 0, 100));
  }

  // Get the current balance from the most recent transaction
  public int getBalance() {
    int lastEntry = statement.size() - 1;
    return statement.get(lastEntry).getCurrentBalance();
  }

  // Record a new transaction when spending occurs
  public void spend(int amount, String name) {
    int newBalance = getBalance() - amount;
    Transaction transaction = new Transaction(name, amount, newBalance);
    statement.add(transaction);
  }

  // Return the full transaction history
  public List<Transaction> getStatement() {
    return statement;
  }
}

// A single transaction record with spender name, amount spent, and resulting balance
class Transaction {
  private final String name;
  private final int amount;
  private final int currentBalance;

  Transaction(String name, int amount, int currentBalance) {
    this.name = name;
    this.amount = amount;
    this.currentBalance = currentBalance;
  }

  public String getName() {
    return name;
  }

  public int getAmount() {
    return amount;
  }

  public int getCurrentBalance() {
    return currentBalance;
  }

  // Nicely format transaction for printing
  @Override
  public String toString() {
    return "Transaction{" +
            "name='" + name + '\'' +
            ", amount=" + amount +
            ", currentBalance=" + currentBalance +
            '}';
  }
}
