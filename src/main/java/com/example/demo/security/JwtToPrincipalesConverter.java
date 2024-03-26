package com.example.demo.security;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.auth0.jwt.interfaces.DecodedJWT;

@Component
public class JwtToPrincipalesConverter {
	
	private List<SimpleGrantedAuthority>extractAuthoritiesFromClaim(DecodedJWT jwt){
		var claim = jwt.getClaim("role");
		if (claim.isNull()||claim.isMissing())return List.of();
		
		return claim.asList(SimpleGrantedAuthority.class);
		
	}
	public  UserPrincipal convert(DecodedJWT jwt) {
		return UserPrincipal.builder()
				.userId(Long.valueOf(jwt.getSubject()))
				.email(jwt.getClaim("e").asString())
				.authorities(extractAuthoritiesFromClaim(jwt))
				.build();
		
	}

}
