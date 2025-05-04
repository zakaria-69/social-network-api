package com.example.social_network_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.social_network_api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
