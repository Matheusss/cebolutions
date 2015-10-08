/*package com.cebolutions.top.car.security;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.cebolutions.top.car.entity.User;
import com.cebolutions.top.car.repository.UserRepository;

@Configuration
public class CebolutionsSecurityContext implements ApplicationContextAware {

	private static ApplicationContext context;

	public static User getLoggedUser(){

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		UserRepository bean = context.getBean(UserRepository.class);
		User usuario = bean.findByUser(authentication.getName());

		return usuario;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}
}
*/