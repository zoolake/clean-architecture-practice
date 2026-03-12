package account.application.port.in;

import account.domain.AccountState;

public interface SendMoneyUseCase {
    void sendMoney(int amount, AccountState sourceAccountState, AccountState targetAccountState);
}
