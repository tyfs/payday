package com.payday.account.application.persistence;

import java.util.List;

import org.springframework.stereotype.Service;

import com.payday.account.domain.models.Account;
import com.payday.account.domain.models.Transaction;

@Service
public interface IAccountRepository {
  Account Create(Account account);
  Account FindById(Long id);
  List<Account> FindByUserId(Long userId);
  List<Transaction> FindTransactions(Long accountId); 
}
