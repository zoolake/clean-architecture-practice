package unidirectional;

import unidirectional.account.adapter.in.web.AccountController;
import unidirectional.account.adapter.in.web.SendMoneyRequest;
import unidirectional.account.adapter.out.persistence.AccountEntity;
import unidirectional.account.adapter.out.persistence.AccountPersistenceAdapter;
import unidirectional.account.application.port.in.SendMoneyUseCase;
import unidirectional.account.application.port.out.UpdateAccountStatePort;
import unidirectional.account.application.service.SendMoneyService;

public class Main {
    private static final Long SOURCE_ACCOUNT_ID = 1L;
    private static final int SOURCE_ACCOUNT_BALANCE = 3000;

    private static final Long TARGET_ACCOUNT_ID = 2L;
    private static final int TARGET_ACCOUNT_BALANCE = 1000;

    private static final int AMOUNT = 1000;

    public static void main(String[] args) {
        UpdateAccountStatePort updateAccountStatePort = new AccountPersistenceAdapter();
        initializeDatabase(updateAccountStatePort);

        SendMoneyUseCase sendMoneyUseCase = new SendMoneyService(updateAccountStatePort);
        AccountController accountController = new AccountController(sendMoneyUseCase);

        SendMoneyRequest request = new SendMoneyRequest(SOURCE_ACCOUNT_ID, SOURCE_ACCOUNT_BALANCE, TARGET_ACCOUNT_ID, TARGET_ACCOUNT_BALANCE, AMOUNT);
        accountController.sendMoney(request);
    }

    private static void initializeDatabase(UpdateAccountStatePort updateAccountStatePort) {
        AccountPersistenceAdapter database = (AccountPersistenceAdapter) updateAccountStatePort;

        AccountEntity source = new AccountEntity(SOURCE_ACCOUNT_ID, SOURCE_ACCOUNT_BALANCE);
        AccountEntity target = new AccountEntity(TARGET_ACCOUNT_ID, TARGET_ACCOUNT_BALANCE);
        database.initialize(source, target);
    }

}