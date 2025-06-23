package Lesson5.ex05_3_exercise;

// This class manages a collection of customers for a bank, allowing adding and retrieving customers.

public class Bank {

    private Customer[] customers;      // Array to store customers
    private int numberOfCustomers;     // Current count of customers added

    // Constructor initializes the customers array with capacity for 10 customers and count to zero
    public Bank() {
        customers = new Customer[10];
        numberOfCustomers = 0;
    }

    // Adds a new customer to the bank with first name, last name, and branch
    public void addCustomer(String f, String l, Branch b) {
        int i = numberOfCustomers++;      // Use current count as index, then increment
        customers[i] = new Customer(f, l, b);
    }

    // Returns the total number of customers currently in the bank
    public int getNumOfCustomers() {
        return numberOfCustomers;
    }

    // Returns the Customer object at the given index
    public Customer getCustomer(int customerIndex) {
        return customers[customerIndex];
    }
}
