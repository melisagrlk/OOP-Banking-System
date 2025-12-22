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

    // BU METODU EKLE:
    public double getTotalBankBalance() {
        double total = 0;
        for (Account acc : accounts) {
            total += acc.getBalance(); // Account sınıfındaki getBalance() metodunu kullanır
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