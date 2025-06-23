package Lesson6.ex06_2_exercise;

// CheckingAccount class extends Account and implements AccountOperations with overdraft functionality.

public class CheckingAccount extends Account implements AccountOperations {

    private final double overDraftLimit;  // Maximum overdraft allowed

    // Constructor with default overdraft limit of 0
    public CheckingAccount(double balance) {
        this(balance, 0);
    }

    // Constructor to initialize balance and overdraft limit
    public CheckingAccount(double balance, double overDraftLimit) {
        super(balance);
        this.overDraftLimit = overDraftLimit;
    }

    // Returns the current balance
    @Override
    public double getBalance() {
        return balance;
    }

    // Deposits the specified amount by adding to the balance
    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    // Withdraws the specified amount if within balance + overdraft limit; returns true if successful
    @Override
    public boolean withdraw(double amount) {
        if (amount <= balance + overDraftLimit) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    // Returns a description of this account type
    @Override
    public String getDescription() {
        return "Checking Account";
    }

    // Overrides toString to include account type and current balance
    @Override
    public String toString() {
        return this.getDescription() + " balance is " + balance;
    }
}
