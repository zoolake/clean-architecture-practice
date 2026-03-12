package account.application.service;

import account.application.port.in.SendMoneyCommand;
import account.application.port.in.SendMoneyUseCase;
import account.application.port.out.UpdateAccountStatePort;
import account.domain.Account;

public class SendMoneyService implements SendMoneyUseCase {
    private final UpdateAccountStatePort updateAccountStatePort;

    public SendMoneyService(UpdateAccountStatePort updateAccountStatePort) {
        this.updateAccountStatePort = updateAccountStatePort;
    }

    @Override
    public void sendMoney(SendMoneyCommand command) {
        Account source = new Account(command.getSourceAccountId(), command.getSourceAccountBalance());
        Account target = new Account(command.getTargetAccountId(), command.getTargetAccountBalance());

        System.out.println(String.format("[application] *송금거래 이전* 출금계좌:%s --> 금액:%d --> 입금계좌:%s\n", source, command.getAmount(), target));

        source.withdraw(command.getAmount());
        target.deposit(command.getAmount());

        updateAccountStatePort.updateAccountState(source);
        updateAccountStatePort.updateAccountState(target);

        System.out.println(String.format("[application] *송금거래 이후* 출금계좌:%s / 입금계좌:%s\n", source, target));
    }
}
