package example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account with Atm allows the deposit with a fee
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount plus the fee
 */
public class SimpleBankAccountWithAtm extends SimpleBankAccount {

    private final double fee;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance, double fee) {
        super(holder, balance);
        this.fee = fee < 0 ? 0 : fee;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (checkUser(userID) && isDepositAllowed(amount)) {
            this.balance += (amount - this.fee);
        }
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        super.withdraw(userID, amount + this.fee);
    }

    private boolean isWithdrawAllowed(final double amount) {
        return this.balance >= amount + this.fee;
    }

    private boolean isDepositAllowed(final double amount) {
        return amount > this.fee;
    }

}
