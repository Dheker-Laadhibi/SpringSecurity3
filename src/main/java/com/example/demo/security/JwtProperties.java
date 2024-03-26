package com.example.demo.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("security.jwt")
public class JwtProperties {
// define  secretKey inside app properties
	// and change it depending on env
	
	/**
	 * Secret Key used  for ussuing jwt
	 */
	private String secretKey;

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
