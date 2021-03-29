package com.stackroute.UserAuth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.UserAuth.model.User;
import com.stackroute.UserAuth.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User getUserById(String id) {
		return userRepository.findById(id).get();
	}

	public boolean validate(String username, String password) {
		User user = userRepository.findByUsernameAndPassword(username, password);
		if(user != null) {
			return true;
		}
		return false;
	}

	public User addUser(User user) {
		userRepository.save(user);
		return user;
	}
	
	
	
}
