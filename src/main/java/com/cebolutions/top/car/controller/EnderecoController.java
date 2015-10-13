package com.cebolutions.top.car.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

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
import com.cebolutions.top.car.form.EnderecoForm;
import com.cebolutions.top.car.repository.EnderecoRepository;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository repository;
	
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
	@RequestMapping(method = POST, consumes=MediaType.APPLICATION_JSON_VALUE)
//	@ResponseStatus(value = HttpStatus.CREATED)
	public EnderecoDTO create(@RequestBody EnderecoForm form) {
		Endereco endereco = new Endereco();
		
		endereco.setEstado(form.getEstado());
		endereco.setCidade(form.getCidade());
		endereco.setBairro(form.getBairro());
		endereco.setLogradouro(form.getLogradouro());

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
