package Lesson5.ex05_3_exercise;

// Abstract base class representing a bank account with a balance and common operations like deposit and withdrawal.

public abstract class Account {

    protected double balance;  // Current balance in the account

    // Constructor to initialize the account with a starting balance
    public Account(double balance) {
        this.balance = balance;
    }

    // Getter for the current balance
    public double getBalance() {
        return balance;
    }

    // Deposit adds the given amount to the balance
    public void deposit(double amount) {
        balance += amount;
    }

    // Returns a string describing the account and its current balance
    @Override
    public String toString() {
        return getDescription() + ": current balance is " + balance;
    }

    // Abstract method to withdraw an amount from the account;
    // must be implemented by subclasses with specific withdrawal rules
    public abstract boolean withdraw(double amount);

    // Abstract method to provide a description of the account type
    public abstract String getDescription();
}
