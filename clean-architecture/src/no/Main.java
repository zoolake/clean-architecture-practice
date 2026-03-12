package no;

import no.account.adapter.in.web.AccountController;
import no.account.adapter.out.persistence.AccountPersistenceAdapter;
import no.account.application.port.in.SendMoneyUseCase;
import no.account.application.port.out.UpdateAccountStatePort;
import no.account.application.service.SendMoneyService;
import no.account.domain.Account;

public class Main {
    private static final Account source = new Account(1L, 3000);
    private static final Account target = new Account(2L, 0);


    public static void main(String[] args) {
        UpdateAccountStatePort updateAccountStatePort = new AccountPersistenceAdapter();
        initializeDatabase(updateAccountStatePort);

        SendMoneyUseCase sendMoneyUseCase = new SendMoneyService(updateAccountStatePort);
        AccountController accountController = new AccountController(sendMoneyUseCase);

        accountController.sendMoney(source, target, 2000);
    }

    private static void initializeDatabase(UpdateAccountStatePort updateAccountStatePort) {
        AccountPersistenceAdapter database = (AccountPersistenceAdapter) updateAccountStatePort;
        database.initialize(source, target);
    }

}