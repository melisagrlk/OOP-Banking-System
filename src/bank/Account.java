package bank;

import java.util.ArrayList;

public abstract class Account implements Transferable {

    protected String accountNumber;
    private double balance;
    protected ArrayList<Transaction> transactions = new ArrayList<>();

    public Account(String accountNumber, double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException(
                "Initial balance cannot be negative"
            );
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Deposit amount must be positive"
            );
        }
        balance += amount;
        //transactions.add(new Transaction("Deposit", amount));
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

    public abstract boolean withdraw(double amount);

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

        if (this.withdraw(amount)) {
            toAccount.deposit(amount);
           // transactions.add(new Transaction("Transfer", amount));
            return true;
        }

        return false;
    }
}