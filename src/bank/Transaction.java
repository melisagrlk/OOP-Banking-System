package bank;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//This class records the details of a single transaction
public class Transaction {
    private String type; // ex: "Deposit", "Withdrawal"
    private double amount;
    private LocalDateTime timestamp;

    // Constructor: Automatically saves the current time when a transaction is created
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
    
    // toString: Formats the transaction info so it looks nice on the screen
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "[" + timestamp.format(formatter) + "] " + type + ": " + amount;
    }
}
