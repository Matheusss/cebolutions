package com.cebolutions.top.car.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.cebolutions.top.car.security.CustomAuthenticationEntryPoint;

@Configuration
@EnableWebMvcSecurity
@ComponentScan("com.cebolutions.top.car.security")
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService customUserDetailsService;

	@Autowired
	private AuthenticationFailureHandler customAuthenticateFailureHandler;

	@Autowired
	private AuthenticationSuccessHandler customAuthenticationSuccessHandler;
	
	@Autowired
	private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/styles/**");
		web.ignoring().antMatchers("/scripts/**");
		web.ignoring().antMatchers("/views/**");
		web.ignoring().antMatchers("/images/**");
		web.ignoring().antMatchers("/fonts/**");
		web.ignoring().antMatchers("/bower_components/**");
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService)
			.passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/admin/*").authenticated()
				.anyRequest().permitAll()
				.and()
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/login/authenticate")
				.permitAll()
				.and()
			.exceptionHandling()
				.authenticationEntryPoint(customAuthenticationEntryPoint);
		}
}
