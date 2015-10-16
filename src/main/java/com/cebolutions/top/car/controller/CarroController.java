package com.cebolutions.top.car.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cebolutions.top.car.dto.CarroDTO;
import com.cebolutions.top.car.entity.Carro;
import com.cebolutions.top.car.repository.CarroRepository;

@RestController
@RequestMapping(value="/carro")
public class CarroController {
	
	@Autowired
	private CarroRepository repository;
	
	@Transactional
	@RequestMapping(method=GET)
	public List<CarroDTO> list(){
		 List<Carro> carros = (List<Carro>) repository.findAll();
		 
		 return carros.stream()
				.map(CarroDTO::new)
				.collect(Collectors.toList());
	}
	
	@RequestMapping(value="/{id}", method=GET)
	@Transactional(readOnly=true)
	public CarroDTO findById(@PathVariable("id") Long id){
		Carro carro = repository.findOne(id);
		return new CarroDTO(carro);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@Transactional
	public List<Carro> delete(@PathVariable("id") Long id) {
		List<Carro> findAll = new ArrayList<Carro>();
		repository.delete(id);
		findAll = (List<Carro>) repository.findAll();

		return findAll;
	}

}
