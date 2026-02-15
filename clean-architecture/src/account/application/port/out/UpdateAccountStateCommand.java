package account.application.port.out;

public class UpdateAccountStateCommand {
    private final Long accountId;
    private final int balance;

    public UpdateAccountStateCommand(Long accountId, int balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public Long getAccountId() {
        return accountId;
    }

    public int getBalance() {
        return balance;
    }
}
