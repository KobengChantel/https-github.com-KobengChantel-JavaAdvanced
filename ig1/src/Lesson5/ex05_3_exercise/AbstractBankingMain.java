package Lesson5.ex05_3_exercise;

// This class initializes a Bank with customers and accounts, then generates a customer report to display account info.

public class AbstractBankingMain {

    public static void main(String[] args) {
        Bank bank = new Bank();             // Create a new Bank object
        initializeCustomers(bank);          // Add customers and their accounts to the bank

        // Create a CustomerReport object, associate it with the bank, and generate a report
        CustomerReport report = new CustomerReport();
        report.setBank(bank);
        report.generateReport();
    }

    // Method to add sample customers and accounts to the bank
    private static void initializeCustomers(Bank bank) {
        Customer customer;

        // Add customer Will Smith at LA branch with a SavingsAccount of 500
        bank.addCustomer("Will", "Smith", Branch.LA);
        customer = bank.getCustomer(0);
        customer.addAccount(new SavingsAccount(500.00));

        // Add customer Bradley Cooper at Boston branch with SavingsAccount initially 500, then deposit 500 more
        bank.addCustomer("Bradley", "Cooper", Branch.BOSTON);
        customer = bank.getCustomer(1);
        SavingsAccount sack = new SavingsAccount(500.00);
        customer.addAccount(sack);
        sack.deposit(500);

        // Add customer Jane Simms at Mumbai branch with CheckingAccount (balance 200, overdraft 400)
        bank.addCustomer("Jane", "Simms", Branch.MUMBAI);
        customer = bank.getCustomer(2);
        customer.addAccount(new CheckingAccount(200.00, 400.00));

        // Add customer Owen Bryant at Bangalore branch with CheckingAccount (balance 200, no overdraft specified)
        bank.addCustomer("Owen", "Bryant", Branch.BANGALORE);
        customer = bank.getCustomer(3);
        customer.addAccount(new CheckingAccount(200.00));

        // Add customer Tim Soley at LA branch with CheckingAccount (balance 200)
        bank.addCustomer("Tim", "Soley", Branch.LA);
        customer = bank.getCustomer(4);
        customer.addAccount(new CheckingAccount(200.00));

        // Add customer Maria Soley at Bangalore branch with CheckingAccount (balance 100)
        bank.addCustomer("Maria", "Soley", Branch.BANGALORE);
        customer = bank.getCustomer(5);
        CheckingAccount chkAcct = new CheckingAccount(100.00);

        customer.addAccount(chkAcct);

        // Attempt to withdraw 900 from Maria's account, print success and balance if successful
        if (chkAcct.withdraw(900.00)) {
            customer.addAccount(chkAcct);  // (This line appears redundant since account is already added)
            System.out.print(" withdraw is successful" + chkAcct.getBalance());
        }
    }
}
