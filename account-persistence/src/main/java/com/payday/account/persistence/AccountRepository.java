package com.payday.account.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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
	public Account FindById(Long id) {
		return (Account) em.createQuery("from accounts a where a.id = :id")
				.setParameter("id", id)
		        .getSingleResult();
	}
	
	@Override
	public List<Account> FindByUserId(Long userId) {
		return em.createQuery("from accounts a where a.user_id = :user_id", Account.class)
				.setParameter("user_id", userId)
		        .getResultList();
	}

	@Override
	public List<Transaction> FindTransactions(Long accountId) {
		// TODO Auto-generated method stub
		return  em.createQuery("from transactions t where t.account_id = :account_id order by occurred_at",Transaction.class)
				.setParameter("account_id", accountId)
		        .getResultList();
	}

}
