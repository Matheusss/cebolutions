package com.cebolutions.top.car.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoggedUser {
	
	@RequestMapping("/loggedUser")
	public Principal user(Principal user){
		return user;
	}
}
