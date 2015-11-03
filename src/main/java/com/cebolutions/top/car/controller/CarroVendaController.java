package com.cebolutions.top.car.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cebolutions.top.car.dto.CarroVendaDTO;
import com.cebolutions.top.car.entity.Carro;
import com.cebolutions.top.car.entity.CarroVenda;
import com.cebolutions.top.car.form.CarroVendaForm;
import com.cebolutions.top.car.repository.CarroRepository;
import com.cebolutions.top.car.repository.CarroVendaRepository;
import com.cebolutions.top.car.repository.CorRepository;

@RestController
@RequestMapping(value="/carro/customizar/")
public class CarroVendaController {
	
	@Autowired
	CarroVendaRepository repository;
	
	@Autowired
	CarroRepository carroRepository;
	
	@Autowired
	CorRepository corRepository;

	@Transactional
	@RequestMapping(method=POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public CarroVendaDTO create(@RequestParam("id") Long id, @RequestBody CarroVendaForm form){
		
		CarroVenda carroVenda = new CarroVenda();
		Carro carro = carroRepository.findOne(id);
//		List<Cor> cor = (List<Cor>) corRepository.findAll();
		
		carroVenda.setCarro(carro);
		carroVenda.setCor(corRepository.findOne(form.getCorId()));
		
/*		if(carro.getCor().isCorDefault()){
			carroVenda.setCor(carro.getCor());
		} else {
			for (Cor c : cor) {
				if(c.isCorDefault()){
					carroVenda.setCor(c);
				}
			}
		}*/
		
		carroVenda = repository.save(carroVenda);
		return new CarroVendaDTO(carroVenda);
	}
	
/*	@Transactional
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public CarroVendaDTO update(@PathVariable("id") Long id, @RequestBody CarroVendaForm form){
		CarroVenda carroVenda = repository.findOne(id);
		carroVenda.setCor(corRepository.findOne(form.getCorId()));
		
		carroVenda = repository.save(carroVenda);
		
		return new CarroVendaDTO(carroVenda);
	}*/
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@Transactional
	public void delete(@PathVariable("id") Long id) {
		repository.delete(id);
	}

}
