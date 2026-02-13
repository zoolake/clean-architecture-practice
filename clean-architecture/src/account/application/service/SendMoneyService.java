package account.application.service;

import account.application.port.in.SendMoneyUseCase;
import account.application.port.out.UpdateAccountStatePort;
import account.domain.Account;

public class SendMoneyService implements SendMoneyUseCase {
    private final UpdateAccountStatePort updateAccountStatePort;

    public SendMoneyService(UpdateAccountStatePort updateAccountStatePort) {
        this.updateAccountStatePort = updateAccountStatePort;
    }

    @Override
    public void sendMoney(Account source, Account target, int amount) {
        System.out.println(String.format("[application] *송금거래 이전* 출금계좌:%s --> 금액:%d --> 입금계좌:%s\n", source, amount, target));

        source.withdraw(amount);
        target.deposit(amount);
        updateAccountStatePort.updateAccountState(source);
        updateAccountStatePort.updateAccountState(target);

        System.out.println(String.format("[application] *송금거래 이후* 출금계좌:%s / 입금계좌:%s\n", source, target));
    }
}
