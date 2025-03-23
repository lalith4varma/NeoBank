package com.NeoBank.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationImpl {
	
	private final PasswordEncoder passwordEncoder;
	private final UserDetailsImpl userDetailsImpl;
	
	public RegistrationImpl(PasswordEncoder passwordEncoder, UserDetailsImpl userDetailsImpl) {
		this.passwordEncoder = passwordEncoder;
		this.userDetailsImpl = userDetailsImpl;
	}
	
	public void registerUser(String username, String password) {
		
		UserDetails newUser = User
				.withUsername(username)
				.password(passwordEncoder.encode(password))
				.roles("USER")
				.build();
		
		userDetailsImpl.createUser(newUser);
	}
}
