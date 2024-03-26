package com.example.demo.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LoginRequest;
import com.example.demo.model.LoginResponse;
import com.example.demo.security.JwtIssuer;

@RestController

public class AuthController {
	
	private  final JwtIssuer JwtIssuer;
	
	
	
	
	public AuthController(com.example.demo.security.JwtIssuer jwtIssuer) {
		super();
		JwtIssuer = jwtIssuer;
	}




	// login endpoint 
	@PostMapping("/auth/login")
	public LoginResponse login(@RequestBody @Validated LoginRequest request ) {
		//1L user ID type of Long 
		//   List of This creates an immutable list containing the single element "user". 
	 var token =JwtIssuer.issue(1L, request.getEmail(), List.of("user"));
		
		
		
		return LoginResponse.builder()
				
				.accessToken(token)
				.build();
		
	}

}
