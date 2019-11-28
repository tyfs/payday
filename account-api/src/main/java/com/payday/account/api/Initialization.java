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



@Component
public class Initialization implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(Initialization.class);

    @Autowired
    private IAccountRepository repository;
	
    @Override
    public void run(String... args) throws Exception {
    	repository.Create(new Account(1001L,AccountType.DEBIT, new BigDecimal(100.0),LocalDateTime.now(),AccountStatus.ACTIVE));    	   	
        
    }
    
}
