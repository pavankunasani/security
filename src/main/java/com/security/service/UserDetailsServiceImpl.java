package com.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.domain.CustomUserDetails;
import com.security.domain.User;
import com.security.repo.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	Optional<User>	optionalUser= this.userRepo.findByName(username);
		
	optionalUser.orElseThrow(() -> new UsernameNotFoundException("user not found"));
	
//	optionalUser.ifPresent(user -> new CustomUserDetails(user));
	
	return optionalUser.map(CustomUserDetails::new).get();
	
		
	}

}
