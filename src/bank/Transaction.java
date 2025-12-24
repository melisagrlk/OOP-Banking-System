package bank;
import java.time.LocalDateTime;

public class Transaction {
    private String type; // ex: "Deposit", "Withdrawal"
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now(); // Record the time of the transaction.
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
    
    public LocalDateTime getTimestamp() {
    	return timestamp;
    }
}
