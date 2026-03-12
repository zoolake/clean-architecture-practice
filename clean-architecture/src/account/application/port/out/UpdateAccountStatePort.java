package account.application.port.out;

import account.domain.Account;
import account.domain.AccountState;

public interface UpdateAccountStatePort {
    void updateAccountState(AccountState accountState);
}
