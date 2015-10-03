package com.cebolutions.top.car.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@EnableScheduling
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.cebolutions.top.car.controller", "com.cebolutions.top.car.service"})
public class AppWebConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("styles/**").addResourceLocations("site/dist/styles/");
		registry.addResourceHandler("scripts/**").addResourceLocations("site/dist/scripts/");
		registry.addResourceHandler("views/**").addResourceLocations("site/dist/views/");
		registry.addResourceHandler("fonts/**").addResourceLocations("site/dist/fonts/");
		registry.addResourceHandler("images/**").addResourceLocations("site/dist/images/");
		registry.addResourceHandler("bower_components/**").addResourceLocations("site/dist/bower_components/");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {

		CommonsMultipartResolver config = new CommonsMultipartResolver();
		config.setDefaultEncoding("UTF-8");

		return config;
	}

	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setSuffix(".html");
		return resolver;
	}
}
