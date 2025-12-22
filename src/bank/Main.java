package bank;

public class Main {
    public static void main(String[] args) {
        Bank myBank = new Bank();
        Account sav1 = new SavingsAccount("S123", 1000.0, 5.0);
        Account chk1 = new CheckingAccount("C456", 500.0, 200.0);
        myBank.addAccount(sav1);
        myBank.addAccount(chk1);

        myBank.displayAllAccounts();

        if (sav1 instanceof SavingsAccount) {
            ((SavingsAccount) sav1).applyInterest();
        }

        System.out.println("Total Bank Balance: " + myBank.getTotalBankBalance());
    }
}