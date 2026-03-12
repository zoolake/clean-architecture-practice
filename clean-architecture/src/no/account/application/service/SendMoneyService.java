package no.account.application.service;

import no.account.application.port.in.SendMoneyUseCase;
import no.account.application.port.out.UpdateAccountStatePort;
import no.account.domain.Account;

public class SendMoneyService implements SendMoneyUseCase {
    private final UpdateAccountStatePort updateAccountStatePort;

    public SendMoneyService(UpdateAccountStatePort updateAccountStatePort) {
        this.updateAccountStatePort = updateAccountStatePort;
    }

    @Override
    public void sendMoney(Account source, Account target, int amount) {
        System.out.println(String.format("[거래시작] 출금계좌ID:%d --> 금액:%d --> 입금계좌ID:%d", source.getAccountId(), amount, target.getAccountId()));
        source.withdraw(amount);
        target.deposit(amount);

        updateAccountStatePort.updateAccountState(source);
        updateAccountStatePort.updateAccountState(target);
    }
}
