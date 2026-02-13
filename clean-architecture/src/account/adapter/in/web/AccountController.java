package account.adapter.in.web;

import account.application.port.in.SendMoneyUseCase;
import account.domain.Account;

public class AccountController {
    private final SendMoneyUseCase sendMoneyUseCase;

    public AccountController(SendMoneyUseCase sendMoneyUseCase) {
        this.sendMoneyUseCase = sendMoneyUseCase;
    }

    public void sendMoney(SendMoneyRequest request) {
        System.out.println(String.format("[web] 송금 요청이 들어왔습니다 : %s\n", request));

        Account sourceAccount = new Account(request.getSourceAccountId(), request.getSourceAccountBalance());
        Account targetAccount = new Account(request.getTargetAccountId(), request.getTargetAccountBalance());
        sendMoneyUseCase.sendMoney(sourceAccount, targetAccount, request.getAmount());
    }

}
