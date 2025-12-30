package bank;

//This class is for accounts that can go below zero (Overdraft)
public class CheckingAccount extends Account {
	
	// The limit for how much the account can go into negative
    private double overdraftLimit; //ex: 500.0

    public CheckingAccount(String accountNumber, double balance, double overdraftLimit) {
    	// Send basic info to the parent Account class
    	super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    // Polymorphism: We change how 'withdraw' works for this specific account
    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && (getBalance() + overdraftLimit) >= amount) {
            setBalance(getBalance() - amount);
            addTransaction("Withdrawal (Overdraft)", amount);
            return true;
        }
        // If money is not enough, show error
        System.out.println("Overdraft limit exceeded!");
        return false;
    }
}