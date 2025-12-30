package bank;

//Interface: This is like a rule book. 
//Any class that "implements" this MUST have a transfer feature.
public interface Transferable {
	
	boolean transfer(Account toAccount, double amount);
	// This method says: "I don't know HOW you will transfer money yet, 
    // but you MUST have a method named 'transfer' that takes a target account and an amount."
}
