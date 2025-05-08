package com.example.social_network_api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.social_network_api.dto.RegisterRequest;
import com.example.social_network_api.model.Role;
import com.example.social_network_api.model.User;
import com.example.social_network_api.repository.UserRepository;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User register(RegisterRequest request) {
		Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
		if(existingUser.isPresent()) {
			throw new RuntimeException("Email already exists");
		}
		User user = new User();
		user.setEmail(request.getEmail());
		user.setName(request.getName());
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole(Role.User);
		return userRepository.save(user);
	}
}
