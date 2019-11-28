package com.payday.iam.application.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.payday.iam.domain.models.User;

@Service
public interface IUserService extends UserDetailsService{
	User SignUp(User customer);
	User FindUserByEmailAddress(String emailAddress);
}
