package bank;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

//This class is used to automatically test if our bank code works correctly
public class AccountTest {
    private CheckingAccount checking;
    private SavingsAccount savings;
    
    // This runs BEFORE each test to prepare fresh account objects
    @BeforeEach
    void setUp() {
        checking = new CheckingAccount("CH-101", 1000.0, 500.0);
        savings = new SavingsAccount("SA-202", 1000.0, 0.05);
    }

    @Test
    void testWithdrawalLogic() {
    	// Test 1: Check if withdrawal rules work for both account types (Polymorphism)
        assertTrue(checking.withdraw(1200.0), "Checking should allow overdraft.");
        assertFalse(savings.withdraw(1200.0), "Savings should not exceed balance.");
    }

    @Test
    void testTransferFunctionality() {
    	// Test 2: Check if money transfer between accounts is successful (Interface)
        checking.transfer(savings, 200.0);
        assertEquals(800.0, checking.getBalance(), "Sender balance must decrease.");
        assertEquals(1200.0, savings.getBalance(), "Receiver balance must increase.");
    }

    @Test
    void testEncapsulationAndDeposit() {
    	// Test 3: Check if depositing money updates the balance correctly
        checking.deposit(300.0);
        assertEquals(1300.0, checking.getBalance(), "Deposit should update balance correctly.");
    }
    
    @Test
    void testInterestAndReport() {
    	// Test 4: Check if interest is calculated and added to the savings account
        savings.applyInterest(); // Apply interest logic
        assertTrue(savings.getBalance() > 1000.0, "Balance should increase after interest.");
        savings.printMonthlyReport(); // Print summary to console
    }
}