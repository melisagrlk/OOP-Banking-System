package bank;

import java.io.*;
import java.util.*;

public class FileHandler {
    private static final String FILE_NAME = "bank_data.csv";

    public static void saveAccounts(List<Account> accounts) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            writer.println("Type,AccountNumber,Balance,SpecialField");
            for (Account acc : accounts) {
                String type = (acc instanceof SavingsAccount) ? "Savings" : "Checking";
                double specialField = (acc instanceof SavingsAccount) 
                    ? ((SavingsAccount) acc).getMinBalance() 
                    : ((CheckingAccount) acc).getOverdraftLimit();
                
                writer.printf("%s,%s,%.2f,%.2f%n", type, acc.getAccountNumber(), acc.getBalance(), specialField);
            }
        } catch (IOException e) {
            System.err.println("❌ CSV Export Error: " + e.getMessage());
        }
    }
}