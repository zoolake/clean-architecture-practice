package unidirectional.account.application.service;

import unidirectional.account.application.port.in.SendMoneyUseCase;
import unidirectional.account.application.port.out.UpdateAccountStatePort;
import unidirectional.account.domain.Account;
import unidirectional.account.domain.AccountState;

public class SendMoneyService implements SendMoneyUseCase {
    private final UpdateAccountStatePort updateAccountStatePort;

    public SendMoneyService(UpdateAccountStatePort updateAccountStatePort) {
        this.updateAccountStatePort = updateAccountStatePort;
    }

    @Override
    public void sendMoney(int amount, AccountState sourceAccountState, AccountState targetAccountState) {
        Account source = Account.fromAccountState(sourceAccountState);
        Account target = Account.fromAccountState(targetAccountState);

        System.out.println(String.format("[application] *송금거래 이전* 출금계좌:%s --> 금액:%d --> 입금계좌:%s\n", source, amount, target));

        source.withdraw(amount);
        target.deposit(amount);

        updateAccountStatePort.updateAccountState(source);
        updateAccountStatePort.updateAccountState(target);

        System.out.println(String.format("[application] *송금거래 이후* 출금계좌:%s / 입금계좌:%s\n", source, target));

    }
}
