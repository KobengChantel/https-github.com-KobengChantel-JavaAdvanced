package Lesson5.ex05_1_exercise;

// Abstract class representing a bank account with basic balance management and abstract withdrawal and description methods.

public abstract class Account {

    protected double balance;  // The current balance in the account

    // Constructor to initialize the account with a starting balance
    public Account(double balance) {
        this.balance = balance;
    }

    // Returns the current balance
    public double getBalance() {
        return balance;
    }

    // Adds the specified amount to the balance
    public void deposit(double amount) {
        balance += amount;
    }

    // Returns a string with the account description and current balance
    @Override
    public String toString() {
        return getDescription() + ": current balance is " + balance;
    }

    // Abstract method to withdraw an amount; must be implemented by subclasses
    public abstract boolean withdraw(double amount);

    // Abstract method to get the account description; must be implemented by subclasses
    public abstract String getDescription();
}
