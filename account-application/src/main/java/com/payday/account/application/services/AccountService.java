package com.payday.account.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payday.account.application.persistence.IAccountRepository;
import com.payday.account.domain.models.Account;
import com.payday.account.domain.models.Transaction;

@Service
public class AccountService implements IAccountService{
	@Autowired
	private IAccountRepository accountRepository;

	@Override
	public Account Create(Account account) { 
		return accountRepository.Create(account);
	}

	@Override
	public Account FindById(Long id) { 
		return accountRepository.FindById(id);
	}

	@Override
	public List<Account> FindByUserId(Long userId) { 
		return accountRepository.FindByUserId(userId);
	}

	@Override
	public List<Transaction> FindTransactions(Long accountId) {
		return accountRepository.FindTransactions(accountId);
	}

}
