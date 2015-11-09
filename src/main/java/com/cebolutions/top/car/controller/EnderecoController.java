package com.cebolutions.top.car.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cebolutions.top.car.dto.EnderecoDTO;
import com.cebolutions.top.car.entity.Endereco;
import com.cebolutions.top.car.entity.User;
import com.cebolutions.top.car.form.EnderecoForm;
import com.cebolutions.top.car.repository.EnderecoRepository;
import com.cebolutions.top.car.repository.UserRepository;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly=true)
	@RequestMapping(method=GET)
	public List<EnderecoDTO> list(){
		 List<Endereco> endereco = (List<Endereco>) repository.findAll();
		 
		 return endereco.stream()
			.map(EnderecoDTO::new)
			.collect(Collectors.toList());
	}
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/{id}", method=GET)
	public EnderecoDTO findById(@PathVariable("id") Long id){
		Endereco endereco = repository.findOne(id);
		return new EnderecoDTO(endereco);
	}
	
	@Transactional
	@RequestMapping(value="/endereco/{userId}", method=GET)
	public List<EnderecoDTO> findByUser(@PathVariable("userId") Long userId){
		
		User user = userRepository.findOne(userId);
		List<Endereco> enderecos = (List<Endereco>) repository.findAll();		
		List<Endereco> enderecosByUser = new ArrayList<>();
		
		for (Endereco e : enderecos) {
			for (Endereco eUser : user.getEndereco()) {
				if(e == eUser){
					enderecosByUser.add(e);
				}
			}
		}
		
		
		
		return enderecosByUser.stream()
				.map(EnderecoDTO::new)
				.collect(Collectors.toList());
	}
	
	@Transactional
	@RequestMapping(method = POST, consumes=MediaType.APPLICATION_JSON_VALUE)
//	@ResponseStatus(value = HttpStatus.CREATED)
	public EnderecoDTO create(@RequestBody EnderecoForm form) {
		Endereco endereco = new Endereco();
		
		endereco.setEstado(form.getEstado());
		endereco.setCidade(form.getCidade());
		endereco.setBairro(form.getBairro());
		endereco.setLogradouro(form.getLogradouro());
		endereco.setCep(form.getCep());

		repository.save(endereco);
		return new EnderecoDTO(endereco);
	}
	
/*	@Transactional
	@RequestMapping(value="/{id}", method=PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public EnderecoDTO update(@PathVariable("id") Long id, @RequestBody EnderecoForm form){
		Endereco endereco = repository.findOne(id);
		
		endereco.setEstado(form.getEstado());
		endereco.setCidade(form.getCidade());
		endereco.setBairro(form.getBairro());
		endereco.setLogradouro(form.getLogradouro());

		repository.save(endereco);
		return new EnderecoDTO(endereco);
	}*/

}
