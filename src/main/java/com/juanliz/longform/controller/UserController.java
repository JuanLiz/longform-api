package com.juanliz.longform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juanliz.longform.model.User;
import com.juanliz.longform.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	// Create user
	@PostMapping("/users")
	public ResponseEntity<?> save(@RequestBody User user) {
		return ResponseEntity.ok().body(userService.save(user));
	}

	// Read all users and filter if the request has parameters
	@GetMapping("/users")
	public ResponseEntity<?> read(@RequestParam(required = false) String email,
			@RequestParam(required = false) String name, 
			@RequestParam(required = false) String role,
			@RequestParam(required = false) String finished 
			) {
		return ResponseEntity.ok().body(userService.read(email, name, role, finished));
	}
	
	// Read user by id
	@GetMapping("/users/{id}")
	public ResponseEntity<?> findByid(@PathVariable String id) {
		return ResponseEntity.ok().body(userService.findById(id).get());
	}

	// Update user
	@PutMapping("/users")
	public ResponseEntity<?> update(@RequestBody User user) {
		return ResponseEntity.ok().body(userService.save(user));
	}

	// Delete user by id
	@DeleteMapping("/users/{id}")
	public void deleteById(@PathVariable String id) {
		userService.deleteById(id);
	}
	

}
