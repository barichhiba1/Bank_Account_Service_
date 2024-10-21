package org.sid.Bank_Account_Service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.Bank_Account_Service.enums.AccountType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BankAccountRequestDTO {


    private Double balance;
    private String currency;

    private AccountType type;
}
