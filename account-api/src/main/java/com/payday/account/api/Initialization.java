package com.payday.account.api;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.payday.account.application.persistence.IAccountRepository;
import com.payday.account.domain.models.Account;
import com.payday.account.domain.models.AccountStatus;
import com.payday.account.domain.models.AccountType;
import com.payday.account.domain.models.Transaction;



@Component
public class Initialization implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(Initialization.class);

    @Autowired
    private IAccountRepository repository;
	
    @Override
    public void run(String... args) throws Exception {
    	repository.DeleteAllTransactions();
    	repository.DeleteAll();
    	
    	Account account =  repository.Create(new Account(3L,AccountType.DEBIT, new BigDecimal(100.0),LocalDateTime.now(),AccountStatus.ACTIVE));    	   	
    	
    	//Long accountId, LocalDateTime occurredAt, String description, BigDecimal amount
    	repository.CreateTransaction(new Transaction(account.getId(),LocalDateTime.now(),"Sample Description 1",new BigDecimal(10.0)));
    	repository.CreateTransaction(new Transaction(account.getId(),LocalDateTime.now().minusDays(10),"Sample Description 2",new BigDecimal(20.0)));        
    	repository.CreateTransaction(new Transaction(account.getId(),LocalDateTime.now().minusDays(15),"Sample Description 3",new BigDecimal(70.0)));
    }
    
}
