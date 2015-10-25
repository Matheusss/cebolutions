package com.cebolutions.top.car.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cebolutions.top.car.dto.UserDTO;
import com.cebolutions.top.car.entity.Endereco;
import com.cebolutions.top.car.entity.User;
import com.cebolutions.top.car.form.UserForm;
import com.cebolutions.top.car.repository.EnderecoRepository;
import com.cebolutions.top.car.repository.UserRepository;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Transactional(readOnly = true)
	@RequestMapping(method = GET)
	public List<UserDTO> list() {
		List<User> users = (List<User>) repository.findAll();
		return users.stream()
				.map(UserDTO::new)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	@RequestMapping(value = "/{id}", method = GET)
	public UserDTO findById(@PathVariable("id") Long id) {
		return new UserDTO(repository.findOne(id));
	}

	@Transactional
	@RequestMapping(method = POST)
//	@ResponseStatus(value = HttpStatus.CREATED)
	public UserDTO create(@RequestBody UserForm form) {
		User user = new User();
		List<Endereco> enderecos = new ArrayList<Endereco>();
		
		user.setEmail(form.getEmail());
		
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setSenha(passwordEncoder.encode(form.getSenha()));
		
		user.setNome(form.getNome());
		user.setSobrenome(form.getSobrenome());
		user.setCpf(form.getCpf());
		user.setCnh(form.getCnh());
		user.setDataNascimento(form.getDataNascimento());
		user.setCep(form.getCep());
		
/*		for (Long id : form.getEnderecoId()) {
			enderecos.add(enderecoRepository.findOne(id));
		}
		user.setEndereco(enderecos);*/
		

		repository.save(user);
		return new UserDTO(user);
	}

	@Transactional
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public UserDTO update(@PathVariable("id") Long id, @RequestBody UserForm form) {
		User user = repository.findOne(id);
		List<Endereco> enderecos = new ArrayList<Endereco>();

		String email = form.getEmail();
		String senha = form.getSenha();
		user.setEmail(email);
		user.setSenha(senha);
		
		user.setNome(form.getNome());
		user.setSobrenome(form.getSobrenome());
		user.setCpf(form.getCpf());
		user.setCnh(form.getCnh());
		user.setDataNascimento(form.getDataNascimento());
		user.setCep(form.getCep());
		
		for (Long enderecoId : form.getEnderecoId()) {
			enderecos.add(enderecoRepository.findOne(enderecoId));
		}
		user.setEndereco(enderecos);
		
	   /* UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(email, senha);
	    Authentication authentication = authenticationManager.authenticate(authRequest);
	    SecurityContext securityContext = SecurityContextHolder.getContext();
	    securityContext.setAuthentication(authentication);

	    // Create a new session and add the security context.
	    HttpSession session = request.getSession(true);
	    session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);*/


		repository.save(user);
		return new UserDTO(user);
		}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@Transactional
	public UserDTO delete(@PathVariable("id") Long id) {
		
		User user = repository.findOne(id);
		repository.delete(user);
		
		return new UserDTO(user);
		
/*		List<User> findAll = new ArrayList<User>();
		repository.delete(id);
		findAll = (List<User>) repository.findAll();

		return findAll;*/
	}

/*	@RequestMapping(value = "/login", method = GET)
	@Transactional
	public User login(@RequestBody UserForm form) {
		List<User> users = (List<User>) repository.findAll();

		for (User u : users) {

			if (form.getEmail().matches(u.getEmail())) {
				if (form.getSenha().matches(u.getSenha())){
					
				}
			}
		}*/

	//}

}
