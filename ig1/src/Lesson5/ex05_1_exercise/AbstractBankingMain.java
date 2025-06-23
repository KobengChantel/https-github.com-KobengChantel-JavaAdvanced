package Lesson5.ex05_1_exercise;

// This program initializes a bank with customers and accounts, then generates a customer report showing account details.

public class AbstractBankingMain {

    public static void main(String[] args) {
        Bank bank = new Bank();                // Create a new Bank instance
        initializeCustomers(bank);             // Add customers and their accounts to the bank

        // Create a report, assign the bank, and generate the report output
        CustomerReport report = new CustomerReport();
        report.setBank(bank);
        report.generateReport();
    }

    // Helper method to create customers and add accounts to the bank
    private static void initializeCustomers(Bank bank) {
        Customer customer;

        // Add customer Will Smith with a savings account starting with 500
        bank.addCustomer("Will", "Smith");
        customer = bank.getCustomer(0);
        customer.addAccount(new SavingsAccount(500.00));

        // Add customer Bradley Cooper with a savings account, deposit an additional 500
        bank.addCustomer("Bradley", "Cooper");
        customer = bank.getCustomer(1);
        SavingsAccount sack = new SavingsAccount(500.00);
        customer.addAccount(sack);
        sack.deposit(500);

        // Add customer Jane Simms with a checking account having overdraft protection of 400
        bank.addCustomer("Jane", "Simms");
        customer = bank.getCustomer(2);
        customer.addAccount(new CheckingAccount(200.00, 400.00));

        // Add customer Owen Bryant with a checking account with 200 balance
        bank.addCustomer("Owen", "Bryant");
        customer = bank.getCustomer(3);
        customer.addAccount(new CheckingAccount(200.00));

        // Add customer Tim Soley with a checking account with 200 balance
        bank.addCustomer("Tim", "Soley");
        customer = bank.getCustomer(4);
        customer.addAccount(new CheckingAccount(200.00));

        // Add customer Maria Soley with a checking account with 100 balance
        bank.addCustomer("Maria", "Soley");
        customer = bank.getCustomer(5);
        CheckingAccount chkAcct = new CheckingAccount(100.00);
        customer.addAccount(chkAcct);

        // Attempt to withdraw 900 from Maria's checking account; print success and new balance if successful
        if (chkAcct.withdraw(900.00)) {
            System.out.print("Withdraw is successful. New balance: " + chkAcct.getBalance());
        }
    }
}
