package Lesson5.ex05_1_exercise;

// This class models a savings account that earns interest on deposits and restricts withdrawals to available balance.

public class SavingsAccount extends Account {
    Double rateofinterest = 0.06;  // Interest rate of 6%

    // Constructor initializes the account with the starting balance
    public SavingsAccount(double balance) {
        super(balance);
    }

    // Withdraw only allowed if amount is less than or equal to current balance
    @Override
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    // Deposit amount and then add interest on the updated balance
    @Override
    public void deposit(double amount) {
        balance += amount;
        balance += balance * rateofinterest;  // Apply interest immediately on deposit
    }

    // Returns the account type description (note: should be "Savings Account" instead of "Checking Account")
    @Override
    public String getDescription() {
        return "Checking Account";
    }
}
