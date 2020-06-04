package com.techblog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techblog.entites.User;
import com.techblog.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user)
	{
		return userRepository.save(user);
	}

}
