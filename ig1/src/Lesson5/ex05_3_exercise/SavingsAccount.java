package Lesson5.ex05_3_exercise;

// SavingsAccount extends Account and applies an interest rate on deposits; withdrawals allowed only up to balance.

public class SavingsAccount extends Account {
    Double rateofinterest = 0.06;  // Interest rate of 6%

    // Constructor initializes the account with a starting balance
    public SavingsAccount(double balance) {
        super(balance);
    }

    // Withdraws the amount only if sufficient balance exists (no overdraft allowed)
    @Override
    public boolean withdraw(double amount) {
        if(amount <= balance) {
            balance -= amount;
            return true;  // Withdrawal successful
        } else {
            return false; // Insufficient funds, withdrawal denied
        }
    }

    // Deposit adds the amount and then applies interest on the new balance
    @Override
    public void deposit(double amount) {
        balance += amount;
        balance += balance * rateofinterest;  // Apply interest after deposit
    }

    // Returns a description of this account type
    @Override
    public String getDescription() {
        return "Savings Account";
    }
}
