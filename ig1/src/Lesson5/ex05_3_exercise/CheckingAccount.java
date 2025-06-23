package Lesson5.ex05_3_exercise;

// CheckingAccount class extends Account and allows withdrawals up to the balance plus an overdraft limit.

public class CheckingAccount extends Account {

    private final double overDraftLimit;  // Maximum overdraft allowed (how far below zero the balance can go)

    // Constructor with balance only, sets overdraft limit to 0
    public CheckingAccount(double balance) {
        this(balance, 0);
    }

    // Constructor with balance and overdraft limit specified
    public CheckingAccount(double balance, double overDraftLimit) {
        super(balance);
        this.overDraftLimit = overDraftLimit;
    }

    // Withdraw method allows withdrawal if amount is within balance + overdraft limit
    @Override
    public boolean withdraw(double amount) {
        if(amount <= balance + overDraftLimit) {
            balance -= amount;
            return true;    // Withdrawal successful
        } else {
            return false;   // Withdrawal denied due to insufficient funds including overdraft
        }
    }

    // Returns a description of this account type
    @Override
    public String getDescription() {
        return "Checking Account";
    }
}
