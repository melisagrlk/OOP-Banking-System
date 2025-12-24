package bank;

public class CheckingAccount extends Account {
    private double overdraftLimit; //ex: 500.0

    public CheckingAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && (getBalance() + overdraftLimit) >= amount) {
            setBalance(getBalance() - amount);
            addTransaction("Withdrawal (Overdraft)", amount);
            return true;
        }
        System.out.println("Overdraft limit exceeded!");
        return false;
    }
}