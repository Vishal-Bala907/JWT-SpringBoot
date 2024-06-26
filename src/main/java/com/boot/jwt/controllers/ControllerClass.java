package com.boot.jwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.jwt.entities.AuthRequest;
import com.boot.jwt.entities.User;
import com.boot.jwt.service.JwtService;
import com.boot.jwt.service.UserInfoService;

@RestController
@RequestMapping("/auth")
public class ControllerClass {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserInfoService service;

	@Autowired
	JwtService jwtService;
	
	

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome this endpoint is not secure";
	}

	@PostMapping("/addNewUser")
	public String addNewUser(@RequestBody User userInfo) {
		return service.addUser(userInfo);
	}

	@GetMapping("/user/userProfile")
	public String userProfile() {
		return "Welcome to User Profile";
	}

	@GetMapping("/admin/adminProfile")
	public String adminProfile() {
		return "Welcome to Admin Profile";
	}

	@PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }

}
