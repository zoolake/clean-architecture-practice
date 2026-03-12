package unidirectional.account.application.port.out;

import unidirectional.account.domain.AccountState;

public interface UpdateAccountStatePort {
    void updateAccountState(AccountState accountState);
}
