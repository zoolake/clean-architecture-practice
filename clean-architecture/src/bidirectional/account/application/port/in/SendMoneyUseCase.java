package bidirectional.account.application.port.in;

import bidirectional.account.domain.Account;

public interface SendMoneyUseCase {
    void sendMoney(Account source, Account target, int amount);
}
