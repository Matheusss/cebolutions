package com.cebolutions.top.car.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cebolutions.top.car.dto.MarcaDTO;
import com.cebolutions.top.car.entity.Marca;
import com.cebolutions.top.car.form.MarcaForm;
import com.cebolutions.top.car.repository.MarcaRepository;

@RestController
@RequestMapping(value="/marca")
public class MarcaController {

	@Autowired
	private MarcaRepository repository;
	
	@Transactional(readOnly=true)
	@RequestMapping(method=GET)
	public List<MarcaDTO> list(){
		 List<Marca> marca = (List<Marca>) repository.findAll();
		 
		 return marca.stream()
			.map(MarcaDTO::new)
			.collect(Collectors.toList());
	}
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/{id}", method=GET)
	public MarcaDTO findById(@PathVariable("id") Long id){
		Marca marca = repository.findOne(id);
		return new MarcaDTO(marca);
	}
	

	@Transactional
	@RequestMapping(method = POST, consumes=MediaType.APPLICATION_JSON_VALUE)
//	@ResponseStatus(value = HttpStatus.CREATED)
	public MarcaDTO create(@RequestBody MarcaForm form) {
		Marca marca = new Marca();
		
		marca.setNome(form.getNome());
		marca.setLogo(form.getLogo());
		
		repository.save(marca);
		return new MarcaDTO(marca);
	}
	
	@Transactional
	@RequestMapping(value="/{id}", method=PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public MarcaDTO update(@PathVariable("id") Long id, @RequestBody MarcaForm form){
		Marca marca = repository.findOne(id);
		
		marca.setNome(form.getNome());
		marca.setLogo(form.getLogo());
		
		repository.save(marca);
		return new MarcaDTO(marca);
	}
	
	@RequestMapping(value="/{id}", method=DELETE)
	@Transactional
	public MarcaDTO delete(@PathVariable("id") Long id){
		Marca marca = repository.findOne(id);
		repository.delete(marca);
		
		return new MarcaDTO(marca);
	}
}
