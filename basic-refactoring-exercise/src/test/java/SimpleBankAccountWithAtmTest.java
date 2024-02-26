import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccountWithAtm implementation
 */
public class SimpleBankAccountWithAtmTest {

    private static final double FEE = 1;
    private double atmFee;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        atmFee = FEE < 0 ? 0 : 1;
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0, atmFee);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDepositWithAtm() {
        bankAccount.deposit(accountHolder.getId(), 100);
        assertEquals(100 - atmFee, bankAccount.getBalance());
    }

    @Test
    void testWrongDepositWithAtm() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.deposit(accountHolder.getId(), atmFee);
        assertEquals(100 - atmFee, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithAtm() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 70);
        assertEquals(30 - atmFee * 2, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdrawWithAtm() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(2, 70);
        bankAccount.withdraw(accountHolder.getId(), 200);
        assertEquals(100 - atmFee, bankAccount.getBalance());
    }

}
