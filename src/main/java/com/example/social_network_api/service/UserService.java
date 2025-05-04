package com.example.social_network_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.social_network_api.model.User;
import com.example.social_network_api.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	//createUser
	public User createUser(User user) {
		return this.userRepository.save(user);
		
	}
	
	//get user by id
	public User getUserById(Long id) {
		return this.userRepository.findById(id).orElse(null);
	}
	
	// get user by email
	public User getUserByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}
	
	public User UpdateUser(Long id, User userDetails) {
	User user = getUserById(id);
	if(user != null) {
		user.setName(userDetails.getName());
		user.setEmail(userDetails.getEmail());
		return userRepository.save(user);
	}
	return null;
};
//delete user

	public void deleteUser(Long id) {
		this.userRepository.deleteById(id);
	}
}
