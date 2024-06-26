package com.boot.jwt.userdetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.boot.jwt.entities.User;


public class UserInfoDetails implements UserDetails {
	
	private String username;
	private String password;
	private Set<SimpleGrantedAuthority> authorities;

	
	
	
	
	public UserInfoDetails(User user) {
		super();
		this.username = user.getName();
		this.password = user.getPassword();
		
		this.authorities = Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
	}
	
	
	
	public UserInfoDetails() {
		super();
		// TODO Auto-generated constructor stub
	}



	public UserInfoDetails(String username, String password, Set<SimpleGrantedAuthority> authorities) {
		super();
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public void setAuthorities(Set<SimpleGrantedAuthority> authorities) {
		this.authorities = authorities;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	
	
	@Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }




	
	
	
	

}
