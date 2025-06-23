package Lesson6.ex06_2_exercise;

// Represents a bank customer who can have multiple accounts and is associated with a specific branch.

public class Customer {

    private String firstName;                // Customer's first name
    private String lastName;                 // Customer's last name
    private AccountOperations[] accounts;   // Array to hold customer's accounts (up to 10)
    private int numberOfAccounts;            // Current number of accounts the customer has
    private Branch branch;                   // Branch the customer belongs to

    // Constructor initializes customer name, branch, and account array
    public Customer(String f, String l, Branch b) {
        firstName = f;
        lastName = l;
        accounts = new AccountOperations[10];  // Max 10 accounts
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
    public void addAccount(AccountOperations acct) {
        int i = numberOfAccounts++;
        accounts[i] = acct;
    }

    // Returns the number of accounts this customer has
    public int getNumOfAccounts() {
        return numberOfAccounts;
    }

    // Retrieves an account at the specified index
    public AccountOperations getAccount(int accountIndex) {
        return accounts[accountIndex];
    }

    // Getter for the branch the customer belongs to
    public Branch getBranch() {
        return branch;
    }

    // Setter to change the customer's branch
    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
