package Lesson6.ex06_2_exercise;

public abstract class Account {
    
    protected double balance;
    
    public Account(double balance) {
        this.balance = balance;
    }
        
    @Override
    public String toString() {
        return "Current balance is " + balance;
    }    
}