package org.sid.Bank_Account_Service.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.Bank_Account_Service.dto.BankAccountRequestDTO;
import org.sid.Bank_Account_Service.dto.BankAccountResponseDTO;
import org.sid.Bank_Account_Service.entities.BankAccount;
import org.sid.Bank_Account_Service.entities.Customer;
import org.sid.Bank_Account_Service.repository.BankAccountRepository;
import org.sid.Bank_Account_Service.repository.CustomerRepository;
import org.sid.Bank_Account_Service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQlController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerRepository customerRepository;

    @QueryMapping
    public List<BankAccount> accountList() {
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount) {
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccount) {
        return accountService.updateAccount(id, bankAccount);
    }
    @MutationMapping
    public Boolean deleteAccount(@Argument String id) {
bankAccountRepository.deleteById(id);
return  true ;
    }
    @QueryMapping
    public  List<Customer> customers(){
        return  customerRepository.findAll();

    }

}
//graphql est plus optimisé que rest
