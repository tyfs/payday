package com.payday.account.application.persistence;

import java.util.List;

import org.springframework.stereotype.Service;

import com.payday.account.domain.models.Account;
import com.payday.account.domain.models.Transaction;

@Service
public interface IAccountRepository {
  Account Create(Account account);
  Transaction CreateTransaction(Transaction transaction);
  Account FindById(Long userId, Long id);
  void DeleteAll();
  void DeleteAllTransactions();
  List<Account> FindByUserId(Long userId);
  List<Transaction> FindTransactions(Long userId, Long accountId); 
}
