package bank;

//This class is for accounts that save money and earn interest
public class SavingsAccount extends Account {
	private double interestRate;
	
	private double MIN_BALANCE; 
	
	public SavingsAccount(String accountNumber, double balance, double interestRate, double MIN_BALANCE) {
		// Send basic info to the parent Account class
		super(accountNumber, balance);
		this.MIN_BALANCE=MIN_BALANCE;
		this.interestRate=interestRate;
	}
	
	// Polymorphism: Change 'withdraw' for savings rules
	@Override
	public boolean withdraw(double amount) {
		// Check if remaining balance will be at least min balance.
		if (amount > 0 && (getBalance() - amount) >= MIN_BALANCE) {
            setBalance(getBalance() - amount);
            addTransaction("Withdrawal", amount); 
            return true;
        }
        System.out.println("Minimum balance requirement not met!");
        return false;
    }
	
	// Optional Feature: Calculate and add interest to the balance
	public void applyInterest() {
		// Calculate interest and add it using the deposit method
        double interest = getBalance() * interestRate;
        if(interest>0) {
        	this.deposit(interest);
        	addTransaction("Interest Applied", interest);
        }
    }

	public double getMinBalance() {
		return 0;
	}
}