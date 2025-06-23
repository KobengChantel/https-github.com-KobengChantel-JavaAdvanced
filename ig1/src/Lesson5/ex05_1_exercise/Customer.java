package Lesson5.ex05_1_exercise;

// This class represents a bank customer who can have multiple accounts managed in an array.

public class Customer {

    private String firstName;          // Customer's first name
    private String lastName;           // Customer's last name
    private Account[] accounts;        // Array to hold multiple accounts for the customer
    private int numberOfAccounts;      // Tracks how many accounts the customer currently has

    // Constructor initializes customer names and creates accounts array with capacity 10
    public Customer(String f, String l) {
        firstName = f;
        lastName = l;
        accounts = new Account[10];
        numberOfAccounts = 0;
    }

    // Returns the first name of the customer
    public String getFirstName() {
        return firstName;
    }

    // Returns the last name of the customer
    public String getLastName() {
        return lastName;
    }

    // Adds an account to the customer's accounts array
    public void addAccount(Account acct) {
        int i = numberOfAccounts++;
        accounts[i] = acct;
    }

    // Returns the total number of accounts this customer has
    public int getNumOfAccounts() {
        return numberOfAccounts;
    }

    // Returns the account at the specified index
    public Account getAccount(int accountIndex) {
        return accounts[accountIndex];
    }
}
