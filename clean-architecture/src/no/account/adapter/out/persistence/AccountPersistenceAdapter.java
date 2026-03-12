package no.account.adapter.out.persistence;

import no.account.application.port.out.UpdateAccountStatePort;
import no.account.domain.Account;

import java.util.HashMap;
import java.util.Map;

public class AccountPersistenceAdapter implements UpdateAccountStatePort {
    private static final Map<Long, Account> database = new HashMap<>();

    @Override
    public void updateAccountState(Account account) {
        Long accountId = account.getAccountId();
        if (database.containsKey(accountId)) {
            database.put(accountId, account);
        }
    }

    public void initialize(Account... accounts) {
        for (Account account : accounts) {
            database.put(account.getAccountId(), account);
        }
    }

}
