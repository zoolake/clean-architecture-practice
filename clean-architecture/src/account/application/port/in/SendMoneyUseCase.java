package account.application.port.in;

import account.domain.Account;

public interface SendMoneyUseCase {
    void sendMoney(SendMoneyCommand command);
}
