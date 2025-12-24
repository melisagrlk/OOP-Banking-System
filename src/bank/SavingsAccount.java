package bank;

public class SavingsAccount extends Account {
	private double interestRate;
	
	private static final double MIN_BALANCE=100.0; //limit
	
	public SavingsAccount(String accountNumber, double balance, double interestRate) {
		super(accountNumber, balance);
		this.interestRate=interestRate;
	}
	
	@Override
	public boolean withdraw(double amount) {
		if (amount > 0 && (getBalance() - amount) >= MIN_BALANCE) {
            setBalance(getBalance() - amount);
            addTransaction("Withdrawal", amount); 
            return true;
        }
        System.out.println("Minimum balance requirement not met!");
        return false;
    }
	
	public void applyInterest() {
        double interest = getBalance() * (interestRate / 100);
        deposit(interest);
        System.out.println("Interest applied: " + interest);
    }
}