package bank;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Bank myBank = new Bank();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== BANKING SYSTEM CONTROL PANEL ===");

        while (running) {
            try {
                System.out.println("\n--- MAIN MENU ---");
                System.out.println("1. Create Savings Account ");
                System.out.println("2. Create Checking Account ");
                System.out.println("3. Deposit Money");
                System.out.println("4. Withdraw Money");
                System.out.println("5. Show All Accounts");
                System.out.println("6. Transfer Money");
                System.out.println("7. View Transaction History");
                System.out.println("8. Exit");
                System.out.print("Choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                case 1:
                    System.out.print("Account Number: ");
                    String sNum = scanner.next();
                    System.out.print("Initial Balance: ");
                    double sBal = scanner.nextDouble();
                    System.out.print("Set Minimum Balance Limit: "); 
                    double sLimit = scanner.nextDouble();
                    myBank.addAccount(new SavingsAccount(sNum, sBal, sBal, sLimit));
                    System.out.println("✅ Savings Account created.");
                    break;
                case 2:
                    System.out.print("Account Number: ");
                    String cNum = scanner.next();
                    System.out.print("Initial Balance: ");
                    double cBal = scanner.nextDouble();
                    System.out.print("Set Overdraft Limit: "); 
                    double cLimit = scanner.nextDouble();
                    myBank.addAccount(new CheckingAccount(cNum, cBal, cLimit));
                    System.out.println("✅ Checking Account created.");
                    break;
                    case 3:
                        processTransaction(myBank, scanner, true);
                        break;
                    case 4:
                        processTransaction(myBank, scanner, false);
                        break;
                    case 5:
                        System.out.println("\n--- CURRENT ACCOUNT STATUS ---");
                        myBank.displayAllAccounts();
                        break;    
                    case 6:
                        System.out.print("Enter Source Account ID: ");
                        String sourceId = scanner.next();
                        System.out.print("Enter Target Account ID: ");
                        String targetId = scanner.next();
                        System.out.print("Enter Amount to Transfer: ");
                        double transferAmount = scanner.nextDouble();

                        Account sourceAcc = myBank.findAccount(sourceId);
                        Account targetAcc = myBank.findAccount(targetId);

                        if (sourceAcc != null && targetAcc != null) {
                            if (sourceAcc.transfer(targetAcc, transferAmount)) {
                            	
                            	FileHandler.saveAccounts(myBank.getAccounts());
                                System.out.println("✅ Transfer successful!");
                            } else {
                                System.out.println("❌ Transfer failed! Check balance or limits.");
                            }
                        } else {
                            System.out.println("❌ One or both accounts not found!");
                        }
                        break;
                        
                    case 7:
                        System.out.print("Enter Account ID to view history: ");
                        String historyId = scanner.next();
                        
                        Account historyAcc = myBank.findAccount(historyId); 
                        
                        if (historyAcc != null) {
                            historyAcc.displayTransactionHistory(); 
                        } else {
                            System.out.println("❌ Account not found!");
                        }
                        break;
                        
                    case 8:
                        running = false;
                        System.out.println("System closed. Records saved.");
                        break;
                    default:
                        System.out.println("❌ Error: Please select between 1-6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Input Error: Please enter numbers only, not letters!");
                scanner.next(); 
            }catch (IllegalArgumentException e) {
            	System.out.println("\n Warning: "+e.getMessage());
            }
        }
        scanner.close();
    }

    private static void processTransaction(Bank bank, Scanner scanner, boolean isDeposit) {
        if (bank.getAccounts().isEmpty()) {
            System.out.println("❌ No accounts available. Create one first!");
            return;
        }
        
        System.out.print("Enter Account ID: ");
        String id = scanner.next();
        
        Account foundAcc = null;
        for (Account acc : bank.getAccounts()) {
            if (acc.getAccountNumber().equals(id)) {
                foundAcc = acc;
                break;
            }
        }

        if (foundAcc != null) {
            System.out.print("Enter Amount: ");
            double amount = scanner.nextDouble();
            if (isDeposit) {
                foundAcc.deposit(amount);
                System.out.println("✅ Deposit successful.");
            } else {
                foundAcc.withdraw(amount); 
            }
            
            FileHandler.saveAccounts(bank.getAccounts());
            
        } else {
            System.out.println("❌ Account not found!");
        }
    }
}