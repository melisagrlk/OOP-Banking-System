package bank;

import java.util.ArrayList;
import java.util.List;

//This class manages the collection of all bank accounts
public class Bank {
	// A list to store different types of accounts (Savings and Checking)
    private List<Account> accounts;

    // Constructor: Initializes the bank with an empty list of accounts
    public Bank() {
        this.accounts = new ArrayList<>();
    }

    // Method to add a new account to the bank's system
    public void addAccount(Account newAccount) {
    	//Check if this ID exists among the existing accounts.
        for (Account acc : accounts) {
        	if(acc.getAccountNumber().equals(newAccount.getAccountNumber())) {
        		throw new IllegalArgumentException("Account with ID "+newAccount.getAccountNumber()+" already exist!");
        		
        	}
        }
        accounts.add(newAccount);
        
        //Automatically saving to csv
        FileHandler.saveAccounts(this.accounts);
    }

    // Calculates the sum of money in all accounts in the bank
    public double getTotalBankBalance() {
        double total = 0;
        for (Account acc : accounts) {
            total += acc.getBalance(); 
        }
        return total;
    }

    // Prints basic information for every account in the system
    public void displayAllAccounts() {
        System.out.println("\n--- All Bank Accounts ---");
        for (Account acc : accounts) {
            System.out.println("ID: " + acc.getAccountNumber() + " | Balance: " + acc.getBalance());
        }
    }
    
    // Optional Feature: A simple loan system that adds money to an account
    public void applyLoan(Account account, double loanAmount) {
    	// We simulate a loan by depositing the amount into the user's account
        account.deposit(loanAmount);
        System.out.println("Loan of " + loanAmount + " approved for " + account.getAccountNumber());
    }
    
    public List<Account> getAccounts() {
        return this.accounts; 
    }
    
 
    public Account findAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null; 
    }
}