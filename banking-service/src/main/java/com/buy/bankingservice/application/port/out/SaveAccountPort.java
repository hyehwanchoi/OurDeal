package com.buy.bankingservice.application.port.out;

import com.buy.bankingservice.adapter.out.persistence.account.AccountEntity;

public interface SaveAccountPort {

    void save(AccountEntity entity);
}
