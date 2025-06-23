package Lesson5.ex05_1_exercise;

// This class manages a fixed-size list of customers, allowing adding and retrieving customers in a bank.

public class Bank {

    private Customer[] customers;      // Array to store customers
    private int numberOfCustomers;     // Tracks the number of customers added

    // Constructor initializes the customers array with capacity 10 and sets count to 0
    public Bank() {
        customers = new Customer[10];
        numberOfCustomers = 0;
    }

    // Adds a new customer with given first and last name to the array
    public void addCustomer(String f, String l) {
        int i = numberOfCustomers++;
        customers[i] = new Customer(f, l);
    }

    // Returns the total number of customers currently in the bank
    public int getNumOfCustomers() {
        return numberOfCustomers;
    }

    // Returns the Customer object at the specified index
    public Customer getCustomer(int customerIndex) {
        return customers[customerIndex];
    }
}
