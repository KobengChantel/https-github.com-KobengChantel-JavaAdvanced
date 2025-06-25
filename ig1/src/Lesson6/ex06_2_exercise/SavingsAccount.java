package Lesson6.ex06_2_exercise;

// SavingsAccount class extends Account and implements AccountOperations with interest on deposits.

public class SavingsAccount extends Account implements AccountOperations {
    Double rateofinterest = 0.06;  // 6% interest rate

    // Constructor initializes the account balance
    public SavingsAccount(double balance) {
        super(balance);
    }

    // Returns the current balance
    @Override
    public double getBalance() {
        return balance;
    }

    // Withdraws the specified amount if it does not exceed the balance
    @Override
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    // Deposits the amount and applies interest to the new balance
    @Override
    public void deposit(double amount) {
        balance += amount;
        balance += balance * rateofinterest;
    }

    // Returns a description of this account type
    @Override
    public String getDescription() {
        return "Savings Account";
    }

    // Overrides toString to include account type and current balance
    @Override
    public String toString() {
        return this.getDescription() + " balance is " + balance;
    }
}
