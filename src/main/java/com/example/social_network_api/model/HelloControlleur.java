package com.example.social_network_api.model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControlleur {

@GetMapping("/")
public String hello() {
	return "hello, spring boot";
}
	
}
