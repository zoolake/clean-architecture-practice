package full.account.adapter.in.web;

public class SendMoneyRequest {
    private final Long sourceAccountId;
    private final int sourceAccountBalance;
    private final Long targetAccountId;
    private final int targetAccountBalance;
    private final int amount;

    public SendMoneyRequest(Long sourceAccountId, int sourceAccountBalance, Long targetAccountId, int targetAccountBalance, int amount) {
        this.sourceAccountId = sourceAccountId;
        this.sourceAccountBalance = sourceAccountBalance;
        this.targetAccountId = targetAccountId;
        this.targetAccountBalance = targetAccountBalance;
        this.amount = amount;
    }

    public Long getSourceAccountId() {
        return sourceAccountId;
    }

    public int getSourceAccountBalance() {
        return sourceAccountBalance;
    }

    public Long getTargetAccountId() {
        return targetAccountId;
    }

    public int getTargetAccountBalance() {
        return targetAccountBalance;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "SendMoneyRequest{" +
                "sourceAccountId=" + sourceAccountId +
                ", sourceAccountBalance=" + sourceAccountBalance +
                ", targetAccountId=" + targetAccountId +
                ", targetAccountBalance=" + targetAccountBalance +
                ", amount=" + amount +
                '}';
    }
}
