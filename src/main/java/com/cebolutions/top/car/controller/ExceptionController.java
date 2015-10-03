package com.cebolutions.top.car.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cebolutions.top.car.dto.ExceptionDTO;
import com.cebolutions.top.car.exceptions.EmailOverviewException;

@ControllerAdvice
public class ExceptionController {

	@ResponseBody
	@ExceptionHandler(EmailOverviewException.class)
	public ExceptionDTO exceptionHandler(EmailOverviewException exception, HttpServletResponse response){
		response.setStatus(exception.getStatusCode());
		return new ExceptionDTO(exception.getMessage(), exception.getStackTrace().toString());
	}
}
