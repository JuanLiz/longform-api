package com.juanliz.longform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juanliz.longform.model.User;
import com.juanliz.longform.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// Create user
	public User save(User user) {
		return userRepository.save(user);
	}

	// Read all users and by properties if specified
	public List<User> read(String email, String name, String role, String finished){
		return userRepository.filterUsers(email, name, role, finished);
	}

	// Find user by id
	public Optional<User> findById(String id) {
		return userRepository.findById(id);
	}

	// Delete user by id
	public void deleteById(String id) {
		userRepository.deleteById(id);
	}
	


}
