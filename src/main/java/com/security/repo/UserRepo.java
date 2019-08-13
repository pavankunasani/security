package com.security.repo;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {

	Optional<User> findByName(String name);

	
	
}
