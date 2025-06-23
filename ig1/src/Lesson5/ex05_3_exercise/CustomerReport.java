package Lesson5.ex05_3_exercise;

// This class generates and prints a detailed report of all customers in a bank, including their accounts and branch info.

public class CustomerReport {

    private Bank bank;  // Reference to the Bank whose customers will be reported on

    // Getter for the bank
    public Bank getBank() {
        return bank;
    }

    // Setter for the bank
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    // Generates and prints the customer report to the console
    public void generateReport() {

        // Print report header
        System.out.println("\t\t\tCUSTOMERS REPORT");
        System.out.println("\t\t\t================");

        // Loop through all customers in the bank
        for (int custIndex = 0; custIndex < bank.getNumOfCustomers(); custIndex++) {
            Customer customer = bank.getCustomer(custIndex);

            // Print the customer's full name and branch details
            System.out.println();
            System.out.println("Customer: "
                    + customer.getLastName() + ", "
                    + customer.getFirstName()
                    + "\nBranch: " + customer.getBranch() + ", "
                    + customer.getBranch().getServiceLevel());

            // For each account the customer holds...
            for (int acctIndex = 0; acctIndex < customer.getNumOfAccounts(); acctIndex++) {
                Account account = customer.getAccount(acctIndex);

                // Print the account info using its toString method
                System.out.println("    " + account);
            }
        }
    }
}
