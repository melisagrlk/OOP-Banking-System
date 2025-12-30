package bank;

//This class is for accounts that save money and earn interest
public class SavingsAccount extends Account {
	private double interestRate;
	
	// Rule: The account must always have at least 100.0
	private static final double MIN_BALANCE=100.0; 
	
	public SavingsAccount(String accountNumber, double balance, double interestRate) {
		// Send basic info to the parent Account class
		super(accountNumber, balance);
		this.interestRate=interestRate;
	}
	
	// Polymorphism: Change 'withdraw' for savings rules
	@Override
	public boolean withdraw(double amount) {
		// Check if remaining balance will be at least 100.0
		if (amount > 0 && (getBalance() - amount) >= MIN_BALANCE) {
            setBalance(getBalance() - amount);
            addTransaction("Withdrawal", amount); 
            return true;
        }
		// If balance goes below 100.0, show error
        System.out.println("Minimum balance requirement not met!");
        return false;
    }
	
	// Optional Feature: Calculate and add interest to the balance
	public void applyInterest() {
		// Calculate interest and add it using the deposit method
        double interest = getBalance() * (interestRate / 100);
        deposit(interest);
        System.out.println("Interest applied: " + interest);
    }
}