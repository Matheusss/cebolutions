package com.cebolutions.top.car.controller;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cebolutions.top.car.dto.CarroVendaDTO;
import com.cebolutions.top.car.entity.CarroVenda;
import com.cebolutions.top.car.entity.Estoque;
import com.cebolutions.top.car.form.EstoqueForm;
import com.cebolutions.top.car.repository.CarroVendaRepository;
import com.cebolutions.top.car.repository.EstoqueRepository;

@RestController
@RequestMapping(value="/admin/carros")
public class CarroVendaAdminController {
	
	@Autowired
	CarroVendaRepository repository;
	
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/vendidos/", method=GET)
	public List<CarroVendaDTO> list(){
		List<CarroVenda> carrosVenda = (List<CarroVenda>)repository.findAll();
		
		return carrosVenda.stream()
				.map(CarroVendaDTO::new)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/vendidos/{id}", method=GET)
	public CarroVendaDTO findById(@PathVariable("id") Long id){
		CarroVenda carrosVenda = repository.findOne(id);
		return new CarroVendaDTO(carrosVenda);
	}
	
	@Transactional
	@RequestMapping(value="/estoque/{id}", method=PUT)
	public CarroVendaDTO updateEstoque(@PathVariable("id") Long id, EstoqueForm form){
		CarroVenda carro = repository.findOne(id);
		Estoque estoque = estoqueRepository.findByCarroVenda(carro);
		
		estoque.setQuantidade(form.getQuantidade());
		
		return new CarroVendaDTO(carro);
		
	}

}
