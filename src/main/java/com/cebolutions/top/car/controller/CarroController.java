package com.cebolutions.top.car.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cebolutions.top.car.dto.CarroDTO;
import com.cebolutions.top.car.dto.MarcaDTO;
import com.cebolutions.top.car.dto.UserDTO;
import com.cebolutions.top.car.entity.Carro;
import com.cebolutions.top.car.entity.Endereco;
import com.cebolutions.top.car.entity.Marca;
import com.cebolutions.top.car.entity.User;
import com.cebolutions.top.car.form.CarroForm;
import com.cebolutions.top.car.form.UserForm;
import com.cebolutions.top.car.repository.CarroRepository;
import com.cebolutions.top.car.repository.MarcaRepository;

@RestController
@RequestMapping(value="/carro")
public class CarroController {
	
	@Autowired
	private CarroRepository repository;
	
	@Autowired
	private MarcaRepository marcaRepository;
	
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
	
	@Transactional
	@RequestMapping(value="/marcas/{marcaId}", method=GET)
	public List<CarroDTO> findByMarca(@PathVariable("marcaId") Long marcaId){
		
		Marca marca = marcaRepository.findOne(marcaId);
		
		List<Carro> carroPorMarca = (List<Carro>) repository.findByMarca(marca);
		
		return carroPorMarca.stream()
				.map(CarroDTO::new)
				.collect(Collectors.toList());
	}
	
	@RequestMapping(value="/marcasPrincipais", method=GET)
	@Transactional(readOnly=true)
	public List<MarcaDTO>findByPrincipal(){
		
		List<Marca> marcasPrincipais = (List<Marca>)marcaRepository.findByPrincipalTrue();
		
		return marcasPrincipais.stream()
				.map(MarcaDTO::new)
				.collect(Collectors.toList());
	}
	
	@RequestMapping(value="/marcasRestantes", method=GET)
	@Transactional(readOnly=true)
	public List<CarroDTO>findByRestantes(){
				
		List<Marca> marcasRestantes = (List<Marca>)marcaRepository.findByPrincipalFalse();		

		List<Carro> carrosRestantes = new ArrayList<>(); 

		List<Carro> carros = new ArrayList<Carro>(); 

		
				
		for (Marca marca : marcasRestantes) {
			carros = (List<Carro>)repository.findByMarca(marca);
			for (Carro carro : carros) {
				carrosRestantes.add(carro);
			}
		}
		
		
		
		return carrosRestantes.stream()
				.map(CarroDTO::new)
				.collect(Collectors.toList());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@Transactional
	public List<Carro> delete(@PathVariable("id") Long id) {
		List<Carro> findAll = new ArrayList<Carro>();
		repository.delete(id);
		findAll = (List<Carro>) repository.findAll();

		return findAll;
	}
	
	@Transactional
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public CarroDTO update(@PathVariable("id") Long id, @RequestBody CarroForm form) {
		Carro carro = repository.findOne(id);

		carro.setQuantidade(form.getQuantidade());

		repository.save(carro);
		return new CarroDTO(carro);
		}
	


}
