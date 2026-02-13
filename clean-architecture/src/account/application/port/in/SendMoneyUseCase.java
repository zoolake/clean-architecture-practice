package account.application.port.in;

import account.domain.Account;

public interface SendMoneyUseCase {
    void sendMoney(Account source, Account target, int amount);
}
