package com.cebolutions.top.car.controller;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cebolutions.top.car.dto.CarroVendaDTO;
import com.cebolutions.top.car.entity.CarroVenda;
import com.cebolutions.top.car.repository.CarroVendaRepository;

@RestController
@RequestMapping(value="/admin/carros/vendidos/")
public class CarroVendaAdminController {
	
	@Autowired
	CarroVendaRepository repository;
	
	@Transactional(readOnly=true)
	@RequestMapping(method=GET)
	public List<CarroVendaDTO> list(){
		List<CarroVenda> carrosVenda = (List<CarroVenda>)repository.findAll();
		
		return carrosVenda.stream()
				.map(CarroVendaDTO::new)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/{id}", method=GET)
	public CarroVendaDTO findById(@PathVariable("id") Long id){
		CarroVenda carrosVenda = repository.findOne(id);
		return new CarroVendaDTO(carrosVenda);
	}

}
