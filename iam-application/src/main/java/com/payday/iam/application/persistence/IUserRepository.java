package com.payday.iam.application.persistence;

import org.springframework.stereotype.Service;

import com.payday.iam.domain.models.User;

@Service
public interface IUserRepository {
	User Create(User user);
	User FindByEmailAddress(String emailAddress);
}
