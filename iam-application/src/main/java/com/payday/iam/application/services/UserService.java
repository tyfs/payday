package com.payday.iam.application.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.payday.iam.application.persistence.IUserRepository;
import com.payday.iam.domain.models.User;

@Service
public class UserService implements IUserService{

	@Autowired
	private IUserRepository userRepository;

	@Override
	public User SignUp(User user) {
		// TODO Auto-generated method stub
		
		return userRepository.Create(user);
	}

	@Override
	public User FindUserByEmailAddress(String emailAddress) {
		// TODO Auto-generated method stub
		return userRepository.FindByEmailAddress(emailAddress);
	}

	@Override
	public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
        User user = userRepository.FindByEmailAddress(emailAddress);
        if (user == null) {
            throw new UsernameNotFoundException(emailAddress);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmailAddress(), user.getPassword(),
                true, // Email verification status
                true, true,
                true, new ArrayList<>());
	}
	
	
}
