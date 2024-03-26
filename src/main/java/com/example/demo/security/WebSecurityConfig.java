package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
//indique à Spring qu'il s'agit d'une classe de configuration
// recherche les configurations de sécurité Web dans cette classe et les applique à votre application.
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	private final jwtAuthentificationFilter jwtAuthentificationFilter;
	
	
	
	
	
	// nous faisons référence à une méthode annotée avec Bean dans une classe de configuration Spring. Cette méthode est responsable de la création et de la configuration d'un bean spécifique dans le contexte d'application Spring.
	
	//un bean est un objet géré par le conteneur Spring, qui est généralement défini de manière déclarative 
	
	
	public WebSecurityConfig(com.example.demo.security.jwtAuthentificationFilter jwtAuthentificationFilter) {
		super();
		this.jwtAuthentificationFilter = jwtAuthentificationFilter;
	}





	//est une interface clé dans Spring Security qui définit une chaîne de filtres de sécurité pour gérer les requêtes HTTP entrantes dans une application Spring.
	@Bean
	public SecurityFilterChain applicationSecurity(HttpSecurity http)throws Exception {
		http.addFilterBefore(jwtAuthentificationFilter, UsernamePasswordAuthenticationFilter.class);
	
		
		http
        .cors(AbstractHttpConfigurer::disable)
        .csrf(AbstractHttpConfigurer::disable)

        .securityMatcher("/**") // map current config to given resource path
        .sessionManagement(sessionManagementConfigurer
                -> sessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .formLogin(AbstractHttpConfigurer::disable) 
        .authorizeHttpRequests(registry -> registry
                .requestMatchers("/").permitAll()
                .requestMatchers("/auth/login").permitAll()
                // needs to be auth for any rq 
                .anyRequest().authenticated()
        );
		return http.build();
	}

}
