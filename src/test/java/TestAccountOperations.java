import com.company.task16.CheckingAccount;
import com.company.task16.InvalidOperationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAccountOperations {

    @Test
    public void test_checkingAccountCreation_withBalance_success()
    {
        CheckingAccount account = new CheckingAccount(1000);
        assertTrue(account.getBalance() == 1000);
    }

    @Test
    public void test_checkingAccountAddFunds_withValidArgument_success()
    {
        CheckingAccount account = new CheckingAccount(1000);
        try {
            account.addMoney(500);
            } catch (InvalidOperationException ex) {
                fail("Unexpected exception");
            }

        assertEquals(1500, account.getBalance());
    }

    @Test
    public void test_checkingAccountAddFunds_withInvalidArgument_failure()
    {
        CheckingAccount account = new CheckingAccount(1000);
        try {
            account.addMoney(-500);
            fail("Operation is impossible!");
        } catch (InvalidOperationException ex) {
        }
    }

    @Test
    public void test_checkingAccountPay_withSufficientFunds_success()
    {
        CheckingAccount account = new CheckingAccount(1000);
        try {
            account.pay(300);
        } catch (InvalidOperationException ex) {
            fail("Unexpected exception was thrown");
        }

        assertTrue(account.getBalance() == 700);
    }

    @Test
    public void test_checkingAccountPay_withInsufficientFunds_failure()
    {
        CheckingAccount account = new CheckingAccount(1000);
        try {
            account.pay(2000);
            fail("Operation is impossible!");
        } catch (InvalidOperationException ex) {
        }
    }

    @Test
    public void test_transferBetweenTwoCheckingAccounts_withValidArgument_success()
    {
        CheckingAccount account1 = new CheckingAccount(1000);
        CheckingAccount account2 = new CheckingAccount(2000);

        try {
            account1.transfer(account2, 500);
        } catch (InvalidOperationException ex) {
            fail("Unexpected exception");
        }

        assertEquals(500, account1.getBalance());
        assertEquals(2500, account2.getBalance());
    }

    @Test
    public void test_transferBetweenTwoCheckingAccounts_withInvalidArgument_failure()
    {
        CheckingAccount account1 = new CheckingAccount(1000);
        CheckingAccount account2 = new CheckingAccount(2000);

        try {
            account1.transfer(account2, -500);
            fail("Operation is impossible!");
        } catch (InvalidOperationException ex) {
        }

        assertEquals(1000, account1.getBalance());
        assertEquals(2000, account2.getBalance());
    }

    @Test
    public void test_transferBetweenTwoCheckingAccounts_withInsufficientFundsInSource_failure()
    {
        CheckingAccount account1 = new CheckingAccount(1000);
        CheckingAccount account2 = new CheckingAccount(2000);

        try {
            account1.transfer(account2, 1500);
            fail("Operation is impossible!");
        } catch (InvalidOperationException ex) {
        }

        assertEquals(1000, account1.getBalance());
        assertEquals(2000, account2.getBalance());
    }


}
