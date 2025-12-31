package bank;

import java.util.ArrayList;

//Abstract class: This is a general template for all bank accounts
public abstract class Account implements Transferable {

	// Encapsulation: We use private fields to protect data
    private String accountNumber;
    private double balance;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    // Constructor: Sets up the account with initial money
    public Account(String accountNumber, double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException(
                "Initial balance cannot be negative"
            );
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to add money to the balance.
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Deposit amount must be positive"
            );
        }
        balance += amount;
        // Record this movement in the transaction history
        transactions.add(new Transaction("Deposit", amount));
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }
    
    // Helper method to log actions in subclasses
    protected void addTransaction(String type, double amount) {
        this.transactions.add(new Transaction(type, amount));
    }

    // Polymorphism: Subclasses will define their own withdrawal rules
    public abstract boolean withdraw(double amount);

    // Interface Method: Handles money transfer between any two accounts
    @Override
    public boolean transfer(Account toAccount, double amount) {

        if (toAccount == null) {
            throw new IllegalArgumentException(
                "Target account cannot be null"
            );
        }

        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Transfer amount must be positive"
            );
        }

        // Use polymorphism: Try to withdraw first, then deposit to other account
        if (this.withdraw(amount)) {
            toAccount.deposit(amount);
            transactions.add(new Transaction("Transfer", amount));
            return true;
        }

        return false;
    }
    
    // Optional Feature: Simple summary for the account
    public void printMonthlyReport() {
        System.out.println("--- Monthly Report for Account: " + getAccountNumber() + " ---");
        System.out.println("Current Balance: " + getBalance());
        System.out.println("Total Transactions: " + transactions.size());
    }
}