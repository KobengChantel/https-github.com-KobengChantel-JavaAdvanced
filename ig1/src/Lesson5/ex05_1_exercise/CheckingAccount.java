package Lesson5.ex05_1_exercise;

// This class represents a checking account that allows withdrawals up to the balance plus an overdraft limit.

public class CheckingAccount extends Account {
    private final double overDraftLimit;  // Maximum overdraft allowed (how far below zero balance can go)

    // Constructor to create CheckingAccount with initial balance and overdraft limit
    public CheckingAccount(double balance, double overDraftLimit) {
        super(balance);
        this.overDraftLimit = overDraftLimit;
    }

    // Constructor to create CheckingAccount with initial balance and no overdraft allowed (default 0)
    public CheckingAccount(double balance) {
        this(balance, 0);
    }

    // Returns the account type description
    @Override
    public String getDescription() {
        return "Checking Account";
    }

    // Withdraws amount if it does not exceed balance + overdraft limit, returns true if successful
    @Override
    public boolean withdraw(double amount) {
        if (amount <= balance + overDraftLimit) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}
