package com.cebolutions.top.car.init;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Order(1)
public class AppSecurityBootstrap extends AbstractSecurityWebApplicationInitializer {}
