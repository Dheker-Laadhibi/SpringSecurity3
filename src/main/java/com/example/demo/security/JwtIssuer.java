package com.example.demo.security;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class JwtIssuer {
	private final JwtProperties properties;
	
	
	
public JwtIssuer(JwtProperties properties) {
		super();
		this.properties = properties;
	}



public String issue(Long userId , String email , List<String>roles) {
	
	
	
	return JWT.create()
			.withSubject(String.valueOf(userId))
			.withExpiresAt(Instant.now().plus(Duration.of(1, ChronoUnit.DAYS)))
			.withClaim("e", email)
			.withClaim("a", roles)
			
			.sign(Algorithm.HMAC256(properties.getSecretKey()));
}          
}
