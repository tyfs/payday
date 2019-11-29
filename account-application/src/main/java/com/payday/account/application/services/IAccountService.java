package com.payday.account.application.services;

import java.util.List;

import com.payday.account.domain.models.Account;
import com.payday.account.domain.models.Transaction;

public interface IAccountService {
	Account Create(Account account);
	Account FindById(Long userId, Long id);
	List<Account> FindByUserId(Long userId);
	List<Transaction> FindTransactions(Long userId, Long accountId);
}
