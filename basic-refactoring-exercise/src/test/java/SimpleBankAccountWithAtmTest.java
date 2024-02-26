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
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0, FEE);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDepositWithAtm() {
        bankAccount.deposit(accountHolder.getId(), 100);
        assertEquals(100 - FEE, bankAccount.getBalance());
    }

    @Test
    void testWrongDepositWithAtm() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.deposit(accountHolder.getId(), FEE);
        assertEquals(100 - FEE, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithAtm() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 70);
        assertEquals(30 - FEE * 2, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdrawWithAtm() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(2, 70);
        bankAccount.withdraw(accountHolder.getId(), 200);
        assertEquals(100 - FEE, bankAccount.getBalance());
    }

}
