package com.example.demo.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {

    private final Long userId;
    private final String email;
    private final Collection<? extends GrantedAuthority> authorities;

    // Constructeur privé pour le builder
    private UserPrincipal(Long userId, String email, Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.email = email;
        this.authorities = authorities;
    }

    // Méthode de création du builder
    public static UserPrincipalBuilder builder() {
        return new UserPrincipalBuilder();
    }

    // Getter pour userId
    public Long getUserId() {
        return userId;
    }

    // Getter pour email
    public String getEmail() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    // Implémentation des autres méthodes de UserDetails

    // Classe interne pour le builder
    public static class UserPrincipalBuilder {
        private Long userId;
        private String email;
        private Collection<? extends GrantedAuthority> authorities;

        public UserPrincipalBuilder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public UserPrincipalBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserPrincipalBuilder authorities(Collection<? extends GrantedAuthority> authorities) {
            this.authorities = authorities;
            return this;
        }

        // Méthode de construction de UserPrincipal à partir des valeurs définies dans le builder
        public UserPrincipal build() {
            return new UserPrincipal(userId, email, authorities);
        }
    }

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
