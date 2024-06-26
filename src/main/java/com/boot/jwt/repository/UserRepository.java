package com.boot.jwt.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.boot.jwt.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	 Optional<User> findByname(String name);

}
