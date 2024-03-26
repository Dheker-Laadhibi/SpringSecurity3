package com.example.demo.security;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class UserPrincipalAuthentificationToken extends AbstractAuthenticationToken {

	private  final UserPrincipal principal;
	public UserPrincipalAuthentificationToken(UserPrincipal principal) {
		super(principal.getAuthorities());
		this.principal=principal;
		setAuthenticated(true);
		
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPrincipal getPrincipal() {
		// TODO Auto-generated method stub
		return principal;
	}

}
