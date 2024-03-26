package com.example.demo.security;

import java.io.IOException;
import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class jwtAuthentificationFilter  extends OncePerRequestFilter{

	private final jwtDecoder decoder;
	private final JwtToPrincipalesConverter jwttoPconverter;
	
	
	
	
	
	public jwtAuthentificationFilter(jwtDecoder decoder, JwtToPrincipalesConverter jwttoPconverter) {
		super();
		this.decoder = decoder;
		this.jwttoPconverter = jwttoPconverter;
	}





	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		extractTokenFromRequest(request)
		//decoding the token string into jwt
		.map(decoder::decode)
		// converting the decoder token into a principle
		.map(jwttoPconverter::convert)
		// creating new user authentification token 
		
		
		.map(UserPrincipalAuthentificationToken::new)
		
		.ifPresent(auth->SecurityContextHolder.getContext().setAuthentication(auth));
		
		
		filterChain.doFilter(request, response);
		
	}

	// i need to develop extract token from request 
	
	
	private Optional<String>extractTokenFromRequest(HttpServletRequest request){
		var token = request.getHeader("authorization");
		//return true if token is not null 
		// empty token will be null
		if(org.springframework.util.StringUtils.hasText(token) && token.startsWith("Bearer ")) {
			//taking the part of token after bearer and space 
			return Optional.of(token.substring(7));
		}
		return Optional.empty();
	}
	
	
	
	
	
}
