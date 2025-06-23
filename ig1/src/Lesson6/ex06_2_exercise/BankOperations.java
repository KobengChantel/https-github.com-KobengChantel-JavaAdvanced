package Lesson6.ex06_2_exercise;

// Interface defining basic bank operations with a default method to generate a customer report.

public interface BankOperations {

    void addCustomer(String f, String l, Branch b);      // Add a new customer by first name, last name, and branch
    int getNumOfCustomers();                             // Return number of customers in the bank
    Customer getCustomer(int customerIndex);             // Get customer at specified index

    // Default method to generate and print a report of all customers and their accounts
    default void generateReport() {

        // Print report header
        System.out.println("\t\t\tCUSTOMERS REPORT");
        System.out.println("\t\t\t================");

        // Loop through all customers
        for (int custIndex = 0; custIndex < this.getNumOfCustomers(); custIndex++) {
            Customer customer = this.getCustomer(custIndex);

            // Print customer name and branch info
            System.out.println();
            System.out.println("Customer: "
                    + customer.getLastName() + ", "
                    + customer.getFirstName()
                    + "\nBranch: " + customer.getBranch() + ", "
                    + customer.getBranch().getServiceLevel());

            // Loop through customer's accounts and print each
            for (int acctIndex = 0; acctIndex < customer.getNumOfAccounts(); acctIndex++) {
                AccountOperations account = customer.getAccount(acctIndex);

                System.out.println("    " + account);
            }
        }
    }
}
