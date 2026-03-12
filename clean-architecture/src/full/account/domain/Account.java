package full.account.domain;

public class Account {
    private final Long accountId;
    private int balance;

    public Account(Long accountId, int balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public void withdraw(int amount) {
        if (balance < amount) {
            System.out.println("출금액이 잔액보다 많습니다.");
        }

        balance -= amount;
        System.out.println(String.format("[domain] 계좌ID:%d / 출금액:%d / 출금 후 잔액:%d\n", accountId, amount, balance));
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.println(String.format("[domain] 계좌ID:%d / 입금액:%d / 입금 후 잔액:%d\n", accountId, amount, balance));
    }

    public Long getAccountId() {
        return accountId;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", balance=" + balance +
                '}';
    }
}
