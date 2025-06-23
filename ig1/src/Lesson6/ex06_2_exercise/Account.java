package Lesson6.ex06_2_exercise;

// Abstract Account class representing a bank account with a balance and a string representation.

public abstract class Account {

    protected double balance;  // The current balance of the account

    // Constructor to initialize the account with a starting balance
    public Account(double balance) {
        this.balance = balance;
    }

    // Returns a string showing the current balance of the account
    @Override
    public String toString() {
        return "Current balance is " + balance;
    }
}
