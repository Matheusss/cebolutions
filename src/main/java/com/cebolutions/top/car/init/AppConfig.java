package com.cebolutions.top.car.init;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:config/properties", ignoreResourceNotFound = true)
@Import({ AppDataSource.class, AppPersistenceConfig.class })
public class AppConfig {}
