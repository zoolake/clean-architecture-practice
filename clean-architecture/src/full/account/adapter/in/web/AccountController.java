package account.adapter.in.web;

import account.application.port.in.SendMoneyCommand;
import account.application.port.in.SendMoneyUseCase;
import account.domain.Account;

public class AccountController {
    private final SendMoneyUseCase sendMoneyUseCase;

    public AccountController(SendMoneyUseCase sendMoneyUseCase) {
        this.sendMoneyUseCase = sendMoneyUseCase;
    }

    public void sendMoney(SendMoneyRequest request) {
        System.out.println(String.format("[web] 송금 요청이 들어왔습니다 : %s\n", request));

        sendMoneyUseCase.sendMoney(
                new SendMoneyCommand(
                        request.getSourceAccountId(),
                        request.getSourceAccountBalance(),
                        request.getTargetAccountId(),
                        request.getTargetAccountBalance(),
                        request.getAmount()));
    }

}
