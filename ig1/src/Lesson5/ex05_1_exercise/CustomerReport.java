package Lesson5.ex05_1_exercise;

// This class generates a formatted report listing all customers and their accounts in a given bank.

public class CustomerReport {

    private Bank bank;  // Reference to the Bank whose customers will be reported

    // Getter for the bank
    public Bank getBank() {
        return bank;
    }

    // Setter for the bank
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    // Generates and prints the customer report with account details
    public void generateReport() {

        // Print report header
        System.out.println("\t\t\tCUSTOMERS REPORT");
        System.out.println("\t\t\t================");

        // Loop through each customer in the bank
        for (int custIndex = 0; custIndex < bank.getNumOfCustomers(); custIndex++) {
            Customer customer = bank.getCustomer(custIndex);

            // Print the customer's full name in "LastName, FirstName" format
            System.out.println();
            System.out.println("Customer: "
                    + customer.getLastName() + ", "
                    + customer.getFirstName());

            // Loop through all accounts of the current customer
            for (int acctIndex = 0; acctIndex < customer.getNumOfAccounts(); acctIndex++) {
                Account account = customer.getAccount(acctIndex);

                // Print the account details (toString overridden in Account subclasses)
                System.out.println("    " + account);
            }
        }
    }
}
