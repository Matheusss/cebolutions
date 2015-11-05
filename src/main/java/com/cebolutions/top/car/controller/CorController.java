package com.cebolutions.top.car.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cebolutions.top.car.dto.CorDTO;
import com.cebolutions.top.car.entity.Cor;
import com.cebolutions.top.car.repository.CorRepository;

@RestController
@RequestMapping(value="/cor")
public class CorController {
	
	@Autowired
	private CorRepository repository;
	
	@Transactional(readOnly = true)
	@RequestMapping(method = GET)
	public List<CorDTO> list(){
		List<Cor> cores = (List<Cor>) repository.findAll();
		
		return cores.stream()
				.map(CorDTO::new)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	@RequestMapping(value="/{id}",method = GET)
	public CorDTO findById(@PathVariable ("id") Long id){
		Cor cor = repository.findOne(id);
		
		return new CorDTO(cor);
	}
}
