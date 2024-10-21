package org.sid.Bank_Account_Service.service;

import org.sid.Bank_Account_Service.dto.BankAccountRequestDTO;
import org.sid.Bank_Account_Service.dto.BankAccountResponseDTO;
import org.sid.Bank_Account_Service.entities.BankAccount;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

    BankAccountRequestDTO addAccount(BankAccountResponseDTO bankAccountResponseDTO);
}
