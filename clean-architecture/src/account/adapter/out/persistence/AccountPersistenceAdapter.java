package account.adapter.out.persistence;

import account.application.port.out.UpdateAccountStatePort;
import account.domain.Account;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class AccountPersistenceAdapter implements UpdateAccountStatePort {
    private static final Map<Long, AccountEntity> database = new HashMap<>();

    @Override
    public void updateAccountState(Account account) {
        Long accountId = account.getAccountId();
        int balance = account.getBalance();

        if (database.containsKey(accountId)) {
            AccountEntity accountEntity = new AccountEntity(accountId, balance, LocalDateTime.now());
            database.put(accountId, accountEntity);

            System.out.println(String.format("[persistence] 데이터베이스에 저장되었습니다 : %s\n", accountEntity));
        }
    }

    public void initialize(AccountEntity... accountEntities) {
        for (AccountEntity accountEntity : accountEntities) {
            database.put(accountEntity.getAccountId(), accountEntity);
        }

    }

}
