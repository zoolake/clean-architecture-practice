package no.account.application.port.in;

import no.account.domain.Account;

public interface SendMoneyUseCase {
    void sendMoney(Account source, Account target, int amount);
}
