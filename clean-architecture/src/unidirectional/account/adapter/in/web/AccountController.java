package unidirectional.account.adapter.in.web;

import unidirectional.account.application.port.in.SendMoneyUseCase;
import unidirectional.account.domain.AccountState;

public class AccountController {
    private final SendMoneyUseCase sendMoneyUseCase;

    public AccountController(SendMoneyUseCase sendMoneyUseCase) {
        this.sendMoneyUseCase = sendMoneyUseCase;
    }

    public void sendMoney(SendMoneyRequest request) {
        System.out.println(String.format("[web] 송금 요청이 들어왔습니다 : %s\n", request));

        AccountStateImpl sourceAccountState = new AccountStateImpl(request.getSourceAccountId(), request.getSourceAccountBalance());
        AccountStateImpl targetAccountState = new AccountStateImpl(request.getTargetAccountId(), request.getTargetAccountBalance());
        sendMoneyUseCase.sendMoney(request.getAmount(), sourceAccountState, targetAccountState);
    }

    static class AccountStateImpl implements AccountState {
        private final Long accountId;
        private final int balance;

        public AccountStateImpl(Long accountId, int balance) {
            this.accountId = accountId;
            this.balance = balance;
        }

        @Override
        public Long getAccountId() {
            return accountId;
        }

        @Override
        public int getBalance() {
            return balance;
        }
    }

}
