package Lesson6.ex06_2_exercise;

// Interface defining common operations for bank accounts.

public interface AccountOperations {
    double getBalance();           // Returns current balance
    void deposit(double amount);   // Adds amount to balance
    boolean withdraw(double amount); // Attempts to withdraw amount; returns success status
    String getDescription();       // Returns a description of the account type
}
