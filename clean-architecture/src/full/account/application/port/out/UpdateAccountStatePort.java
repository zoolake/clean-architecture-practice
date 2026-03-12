package account.application.port.out;

import account.domain.Account;

public interface UpdateAccountStatePort {
    void updateAccountState(Account account);
}
