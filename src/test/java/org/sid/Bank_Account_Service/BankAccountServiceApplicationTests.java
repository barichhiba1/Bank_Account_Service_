package org.sid.Bank_Account_Service;

import org.sid.Bank_Account_Service.entities.BankAccount;
import org.sid.Bank_Account_Service.enums.AccountType;
import org.sid.Bank_Account_Service.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@EnableJpaRepositories
public class BankAccountServiceApplicationTests{

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplicationTests.class, args);
	}
	@Bean
	CommandLineRunner start (BankAccountRepository bankAccountRepository)
	{
		return args -> {

			for(int i =0;i<10;i++){
				BankAccount bankAccount= BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
						.balance(10000+Math.random()*90000)
						.createdAt(new Date())
						.currency("MAD")
						.build();
				bankAccountRepository.save(bankAccount);

			}
		};

	}
}


