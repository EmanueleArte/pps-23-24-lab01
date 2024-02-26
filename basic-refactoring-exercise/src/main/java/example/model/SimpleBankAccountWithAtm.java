package example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account with Atm allows the deposit with a fee
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount plus the fee
 */
public class SimpleBankAccountWithAtm extends SimpleBankAccount {
    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }
}
