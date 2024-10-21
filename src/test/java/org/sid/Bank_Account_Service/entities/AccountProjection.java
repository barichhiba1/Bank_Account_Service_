package org.sid.Bank_Account_Service.entities;

import org.sid.Bank_Account_Service.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types=BankAccount.class, name = "p1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
    public  Double getBalance();
}
