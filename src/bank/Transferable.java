package bank;

public interface Transferable {
	
	/**
     * Performs a balance transfer from this account to a target account.
     * @param toAccount The destination account for the transfer.
     * @param amount The amount of money to be transferred.
     */
	
	boolean transfer(Account toAccount, double amount);

}
