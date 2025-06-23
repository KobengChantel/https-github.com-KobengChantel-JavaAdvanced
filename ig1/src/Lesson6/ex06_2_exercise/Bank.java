package Lesson6.ex06_2_exercise;

// This class manages a collection of customers for a bank, allowing adding and retrieving customers.

public class Bank implements BankOperations {

    private Customer[] customers;     // Array to store customers
    private int numberOfCustomers;    // Current number of customers

    // Constructor initializes customer array with capacity of 10 and zero customers
    public Bank() {
        customers = new Customer[10];
        numberOfCustomers = 0;
    }

    // Adds a new customer to the bank given first name, last name, and branch
    public void addCustomer(String f, String l, Branch b) {
        int i = numberOfCustomers++;  // Use current count as index, then increment
        customers[i] = new Customer(f, l, b);
    }

    // Returns the number of customers currently in the bank
    public int getNumOfCustomers() {
        return numberOfCustomers;
    }

    // Returns the customer at the specified index
    public Customer getCustomer(int customerIndex) {
        return customers[customerIndex];
    }
}
