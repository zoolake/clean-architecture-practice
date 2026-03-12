package no.account.application.port.out;

import no.account.domain.Account;

public interface UpdateAccountStatePort {
    void updateAccountState(Account account);
}
