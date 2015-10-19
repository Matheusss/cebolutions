package com.cebolutions.top.car.controller;

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

import com.cebolutions.top.car.dto.EstoqueDTO;
import com.cebolutions.top.car.entity.Estoque;
import com.cebolutions.top.car.form.EstoqueForm;
import com.cebolutions.top.car.repository.CarroRepository;
import com.cebolutions.top.car.repository.EstoqueRepository;

@RestController
@RequestMapping(value="/estoque")
public class EstoqueController {
	
	@Autowired
	EstoqueRepository repository;
	
	@Autowired
	CarroRepository carroRepository;
	
	@Transactional(readOnly=true)
	@RequestMapping(method=GET)
	public List<EstoqueDTO> list(){
		 List<Estoque> estoque = (List<Estoque>) repository.findAll();
		 
		 return estoque.stream()
			.map(EstoqueDTO::new)
			.collect(Collectors.toList());
	}
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/{id}", method=GET)
	public EstoqueDTO findById(@PathVariable("id") Long id){
		Estoque estoque = repository.findOne(id);
		return new EstoqueDTO(estoque);
	}
	
	@Transactional
	@RequestMapping(method = POST, consumes=MediaType.APPLICATION_JSON_VALUE)
//	@ResponseStatus(value = HttpStatus.CREATED)
	public EstoqueDTO create(@RequestBody EstoqueForm form) {
		Estoque estoque = new Estoque();
		
		estoque.setCarro(carroRepository.findOne(form.getCarroId()));
		estoque.setQuantidade(form.getQuantidade());
		
		repository.save(estoque);
		return new EstoqueDTO(estoque);
	}
	
	@Transactional
	@RequestMapping(value="/{id}", method=PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public EstoqueDTO update(@PathVariable("id") Long id, @RequestBody EstoqueForm form){
		Estoque estoque= repository.findOne(id);
		
		estoque.setQuantidade(form.getQuantidade());
		
		repository.save(estoque);
		return new EstoqueDTO(estoque);
	}

}
