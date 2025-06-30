package service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void testDepositIncreasesBalance() {
        AccountService account = new Account();
        account.deposit(1000);
    }

    @Test
    public void testWithdrawDecreasesBalance() {
        Account account = new Account();
        account.deposit(1000);
        account.withdraw(400);
        assertTrue(account.wasLastWithdrawSuccessful());
    }

    @Test
    public void testWithdrawInsufficientBalance() {
        Account account = new Account();
        account.deposit(500);

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            account.withdraw(1000);
        });

        assertEquals("Solde insuffisant pour effectuer le retrait.", exception.getMessage());
    }


    @Test
    public void testInvalidDeposit() {
        Account account = new Account();
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-200));
    }
}
