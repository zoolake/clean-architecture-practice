package bidirectional.account.adapter.out.persistence;

import java.time.LocalDateTime;

public class AccountEntity {
    private final Long accountId;
    private final int balance;
    private final LocalDateTime updateAt;

    public AccountEntity(Long accountId, int balance) {
        this.accountId = accountId;
        this.balance = balance;
        this.updateAt = LocalDateTime.now();
    }

    public AccountEntity(Long accountId, int balance, LocalDateTime updateAt) {
        this.accountId = accountId;
        this.balance = balance;
        this.updateAt = updateAt;
    }

    public Long getAccountId() {
        return accountId;
    }

    public int getBalance() {
        return balance;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "accountId=" + accountId +
                ", balance=" + balance +
                ", updateAt=" + updateAt +
                '}';
    }
}
