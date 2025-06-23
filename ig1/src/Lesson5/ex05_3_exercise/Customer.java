package Lesson5.ex05_3_exercise;

// This class represents a bank customer with personal info, a list of accounts, and an associated branch.

public class Customer {

    private String firstName;          // Customer's first name
    private String lastName;           // Customer's last name
    private Account[] accounts;        // Array to hold customer's accounts (max 10)
    private int numberOfAccounts;      // Number of accounts currently held
    private Branch branch;             // Branch where the customer is registered

    // Constructor initializes the customer's name, branch, and prepares accounts array
    public Customer(String f, String l, Branch b) {
        firstName = f;
        lastName = l;
        accounts = new Account[10];   // Max 10 accounts per customer
        numberOfAccounts = 0;
        branch = b;
    }

    // Getter for first name
    public String getFirstName() {
        return firstName;
    }

    // Getter for last name
    public String getLastName() {
        return lastName;
    }

    // Adds an account to the customer's list of accounts
    public void addAccount(Account acct) {
        int i = numberOfAccounts++;  // Use current count as index, then increment
        accounts[i] = acct;
    }

    // Returns number of accounts the customer has
    public int getNumOfAccounts() {
        return numberOfAccounts;
    }

    // Returns the Account at the specified index
    public Account getAccount(int accountIndex) {
        return accounts[accountIndex];
    }

    // Gets the customer's branch
    public Branch getBranch() {
        return branch;
    }

    // Sets or updates the customer's branch
    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
