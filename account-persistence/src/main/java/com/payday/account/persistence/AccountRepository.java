package com.payday.account.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.payday.account.application.persistence.IAccountRepository;
import com.payday.account.domain.models.Account;
import com.payday.account.domain.models.Transaction;

@Service
public class AccountRepository implements IAccountRepository{
	@PersistenceContext private EntityManager em;
	
	
	@Override
	@Transactional
	public Account Create(Account account) {
		// TODO Auto-generated method stub
		em.persist(account);
		return account;
	}
	
	@Override
	@Transactional
	public Transaction CreateTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		em.persist(transaction);
		return transaction;
	}
	
	
	@Override
	@Transactional
	public void DeleteAll() {
		// TODO Auto-generated method stub
		em.createQuery("delete from Account").executeUpdate();
	}
	
	@Override
	@Transactional
	public void DeleteAllTransactions() {
		// TODO Auto-generated method stub
		em.createQuery("delete from Transaction").executeUpdate();
	}

	@Override
	public Account FindById(Long userId, Long id) {
		return (Account) em.createQuery("from Account a where a.id = :id and a.userId = :user_id")
				.setParameter("id", id)
				.setParameter("user_id", userId)
		        .getSingleResult();
	}
	
	@Override
	public List<Account> FindByUserId(Long userId) {
		return em.createQuery("from Account a where a.userId = :user_id", Account.class)
				.setParameter("user_id", userId)
		        .getResultList();
	}

	@Override
	public List<Transaction> FindTransactions(Long userId, Long accountId) {
		// TODO Auto-generated method stub
		return  em.createQuery("select t from Transaction t, Account a where t.accountId = a.id and t.accountId = :account_id and a.userId = :user_id order by t.occurredAt",Transaction.class)
				.setParameter("account_id", accountId)
				.setParameter("user_id", userId)
		        .getResultList();
	}

}
