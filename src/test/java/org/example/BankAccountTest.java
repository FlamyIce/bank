package org.example;// BankAccountTest.java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    private BankAccount account;
    private BankAccount destinationAccount;

    @BeforeEach
    public void setUp() {
        account = new BankAccount("123456", "John Doe", 1000);
        destinationAccount = new BankAccount("654321", "Jane Smith", 500);
    }

    @Test
    public void testInitialBalance() {
        assertEquals(1000, account.getBalance());
    }

    @Test
    public void testDeposit() {
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    public void testDepositNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
    }

    @Test
    public void testWithdraw() {
        account.withdraw(300);
        assertEquals(700, account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        assertThrows(IllegalStateException.class, () -> account.withdraw(2000));
    }

    @Test
    public void testWithdrawNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-100));
    }

    @Test
    public void testTransfer() {
        account.transfer(destinationAccount, 300);
        assertEquals(700, account.getBalance());
        assertEquals(800, destinationAccount.getBalance());
    }

    @Test
    public void testTransferToNullAccount() {
        assertThrows(IllegalArgumentException.class, () -> account.transfer(null, 100));
    }

    @Test
    public void testAccountDetails() {
        assertEquals("123456", account.getAccountNumber());
        assertEquals("John Doe", account.getAccountHolder());
    }
}