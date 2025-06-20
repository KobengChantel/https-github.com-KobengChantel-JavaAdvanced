package Lesson6.ex06_2_exercise;

public interface AccountOperations {
    public double getBalance();
    public void deposit(double amount);
    public boolean withdraw(double amount);
    public String getDescription();
}
