package com.example.social_network_api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import com.example.social_network_api.model.User;
import com.example.social_network_api.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController{

	@Autowired
	private UserService userService;
	
	// endpoint to get user by ID
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	// endpoint to get user by email
	@GetMapping("/email/{email}")
	public Optional<User> getUserByEmail(@PathVariable String email) {
	return userService.getUserByEmail(email);
}
	
	// endpoint to update a user 
	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id,@RequestBody User userDetails) {
		return userService.UpdateUser(id, userDetails); 
	}
	// endpoint to delete a user
	@DeleteMapping("{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
}

