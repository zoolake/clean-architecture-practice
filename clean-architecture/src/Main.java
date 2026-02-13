import account.adapter.in.web.AccountController;
import account.adapter.out.persistence.AccountPersistenceAdapter;
import account.application.port.in.SendMoneyUseCase;
import account.application.port.out.UpdateAccountStatePort;
import account.application.service.SendMoneyService;
import account.domain.Account;

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