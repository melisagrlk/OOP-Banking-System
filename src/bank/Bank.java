package bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public double getTotalBankBalance() {
        double total = 0;
        for (Account acc : accounts) {
            total += acc.getBalance(); 
        }
        return total;
    }

    public void displayAllAccounts() {
        System.out.println("\n--- All Bank Accounts ---");
        for (Account acc : accounts) {
            System.out.println("ID: " + acc.getAccountNumber() + " | Balance: " + acc.getBalance());
        }
    }
}