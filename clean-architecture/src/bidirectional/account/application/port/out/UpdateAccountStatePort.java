package bidirectional.account.application.port.out;

import bidirectional.account.domain.Account;

public interface UpdateAccountStatePort {
    void updateAccountState(Account account);
}
