package com.cebolutions.top.car.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cebolutions.top.car.dto.UserDTO;
import com.cebolutions.top.car.entity.User;
import com.cebolutions.top.car.form.UserForm;
import com.cebolutions.top.car.repository.UserRepository;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserRepository repository;

	@RequestMapping(method=GET)
	@Transactional(readOnly=true)
	public List<UserDTO> list(){
		List<User> users = (List<User>) repository.findAll();
		
		return users.stream()
				.map(UserDTO::new)
				.collect(Collectors.toList());
	}
	
	@RequestMapping(value="/{id}", method=GET)
	@Transactional(readOnly=true)
	public UserDTO findById(@PathVariable("id") Long id){
		User user = repository.findOne(id);
		return new UserDTO(user);
	}
	
	@RequestMapping(method=POST)
	@Transactional
	public User create(@RequestBody UserForm form){
		User user = new User();
		user.setEmail(form.getEmail());
		user.setSenha(form.getSenha());
		
		return repository.save(user);
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	@Transactional
	public User update(@PathVariable("id") Long id, @RequestBody UserForm form){
		User user = repository.findOne(id);
		user.setEmail(form.getEmail());
		user.setSenha(form.getSenha());
		
		return repository.save(user);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	@Transactional
	public List<User> delete(@PathVariable("id") Long id){
		List<User> findAll = new ArrayList<User>();
		repository.delete(id);
		findAll = (List<User>)repository.findAll();
		
		return findAll;
	}

}
