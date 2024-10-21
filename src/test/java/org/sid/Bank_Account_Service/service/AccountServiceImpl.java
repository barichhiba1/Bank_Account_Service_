package org.sid.Bank_Account_Service.service;

import org.sid.Bank_Account_Service.dto.BankAccountRequestDTO;
import org.sid.Bank_Account_Service.dto.BankAccountResponseDTO;
import org.sid.Bank_Account_Service.entities.BankAccount;
import org.sid.Bank_Account_Service.mappers.AccountMapper;
import org.sid.Bank_Account_Service.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements  AccountService{
    @Autowired
 private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {

        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .build();
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);

     BankAccountResponseDTO bankAccountResponseDTO=accountMapper.fromBankAccount(saveBankAccount);




        return bankAccountResponseDTO;
    }

    @Override
    public BankAccountRequestDTO addAccount(BankAccountResponseDTO bankAccountResponseDTO) {
        return null;
    }
}

