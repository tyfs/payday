package com.payday.iam.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.payday.iam.application.persistence.IUserRepository;
import com.payday.iam.domain.models.User;

@Service
public class UserRepository implements IUserRepository{
	@PersistenceContext private EntityManager em;

	@Transactional
	public User Create(User user) {
		// TODO Auto-generated method stub
		em.persist(user);		
		return user;
	}
	
		
	public User FindByEmailAddress(String emailAddress) {
		// TODO Auto-generated method stub
      return (User) em.createQuery("from User u where u.emailAddress = :email_address")
		.setParameter("email_address", emailAddress)
        .getSingleResult();
	}

}
