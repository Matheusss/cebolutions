package com.cebolutions.top.car.security;

import static java.util.Arrays.asList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cebolutions.top.car.entity.User;
import com.cebolutions.top.car.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	private static final String USER_NOT_FOUND = "user.not.found";

	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {

		logger.info("Tentando logar com usuario : " + usuario);

		User user = repository.findByUsername(usuario);
		
		if(user == null) {
			logger.info("Não existe : " + usuario);
			throw new UsernameNotFoundException(USER_NOT_FOUND);
		}
		

		logger.info("Succeeded : " + usuario);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), asList(new SimpleGrantedAuthority("ROLE_USER")));
	}
}
