package bank;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class AccountTest {
    private CheckingAccount checking;
    private SavingsAccount savings;
    private Bank bank;

    @BeforeEach
    void setUp() {
        // Hazırlık: Testler başlamadan önce nesneleri oluşturur
        checking = new CheckingAccount("CH-101", 1000.0, 500.0);
        savings = new SavingsAccount("SA-202", 1000.0, 0.05);
        bank = new Bank();
    }

    @Test
    void testWithdrawalLogic() {
        // 1. Polimorfizm Testi: Vadesiz hesap eksiye düşebilir, vadeli düşemez
        assertTrue(checking.withdraw(1200.0), "Checking should allow overdraft.");
        assertFalse(savings.withdraw(1200.0), "Savings should not exceed balance.");
    }

    @Test
    void testTransferFunctionality() {
        // 2. Interface Testi: Transfer işlemi her iki hesabı da doğru güncelliyor mu?
        checking.transfer(savings, 200.0);
        assertEquals(800.0, checking.getBalance(), "Sender balance must decrease.");
        assertEquals(1200.0, savings.getBalance(), "Receiver balance must increase.");
    }

    @Test
    void testEncapsulationAndDeposit() {
        // 3. Encapsulation Testi: Bakiye sadece deposit ile güvenli artıyor mu?
        checking.deposit(300.0);
        assertEquals(1300.0, checking.getBalance(), "Deposit should update balance correctly.");
    }
    
    
}