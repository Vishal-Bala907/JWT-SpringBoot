package com.boot.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.boot.jwt.entities.User;
import com.boot.jwt.password.PasswordEncoder;
import com.boot.jwt.repository.UserRepository;
import com.boot.jwt.userdetails.UserInfoDetails;

@Service
public class UserInfoService implements UserDetailsService {
	@Autowired
	UserRepository repository;
	@Autowired
	PasswordEncoder passsword;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println(username);
		
		User orElseThrow = repository.findByname(username).orElseThrow(()-> new UsernameNotFoundException("not found"));
		
		
		UserInfoDetails details = new UserInfoDetails(orElseThrow);
		return null;
	}

	public String addUser(User userInfo) {
		userInfo.setPassword(passsword.encode(userInfo.getPassword()));
		repository.save(userInfo);
		return "Saved successfull";
	}
	
	
	
}
