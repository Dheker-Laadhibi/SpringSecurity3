package com.example.demo.security;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component
public class jwtDecoder {
	
	private final JwtProperties properties;
	
	
	
public jwtDecoder(JwtProperties properties) {
		super();
		this.properties = properties;
	}



public DecodedJWT decode(String token) {
	
	
	
	return JWT.require(Algorithm.HMAC256(properties.getSecretKey()))
			.build()
            .verify(token)	;
}
	
	
}
