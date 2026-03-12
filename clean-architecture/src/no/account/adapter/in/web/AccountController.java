package no.account.adapter.in.web;

import no.account.application.port.in.SendMoneyUseCase;
import no.account.domain.Account;

public class AccountController {
    private final SendMoneyUseCase sendMoneyUseCase;

    public AccountController(SendMoneyUseCase sendMoneyUseCase) {
        this.sendMoneyUseCase = sendMoneyUseCase;
    }

    public void sendMoney(Account source, Account target, int amount) {
        sendMoneyUseCase.sendMoney(source, target, amount);
    }

}
