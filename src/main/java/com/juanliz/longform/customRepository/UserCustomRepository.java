package com.juanliz.longform.customRepository;

import java.util.List;

import com.juanliz.longform.model.User;

public interface UserCustomRepository {
	
	public List<User> filterUsers(String email, String name, String role, String finished);

}
