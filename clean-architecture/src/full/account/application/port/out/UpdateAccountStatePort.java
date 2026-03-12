package full.account.application.port.out;

import full.account.domain.Account;

public interface UpdateAccountStatePort {
    void updateAccountState(Account account);
}
