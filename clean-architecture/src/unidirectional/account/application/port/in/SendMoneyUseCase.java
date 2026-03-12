package unidirectional.account.application.port.in;

import unidirectional.account.domain.AccountState;

public interface SendMoneyUseCase {
    void sendMoney(int amount, AccountState sourceAccountState, AccountState targetAccountState);
}
