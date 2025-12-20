package bank;

public class SavingsAccount extends Account {
	private double interestRate;
	
	public SavingsAccount(String accountNumber, double balance, double interestRate) {
		super(accountNumber, balance);
		this.interestRate=interestRate;
	}
	
	public boolean withdraw(double amount) {
		if(amount>0 && getBalance()>=amount) {
			setBalance(getBalance() - amount);
            transactions.add(new Transaction("Withdrawal", amount));
            return true;
        }
        System.out.println("Insufficient funds in Savings Account!");
        return false;
    }
	
	public void applyInterest() {
        double interest = getBalance() * (interestRate / 100);
        deposit(interest);
        System.out.println("Interest applied: " + interest);
    }
}