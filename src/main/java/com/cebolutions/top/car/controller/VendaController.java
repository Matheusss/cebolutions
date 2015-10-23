package com.cebolutions.top.car.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cebolutions.top.car.dto.VendaDTO;
import com.cebolutions.top.car.entity.Carro;
import com.cebolutions.top.car.entity.CarroVenda;
import com.cebolutions.top.car.entity.Cor;
import com.cebolutions.top.car.entity.User;
import com.cebolutions.top.car.entity.Venda;
import com.cebolutions.top.car.form.VendaForm;
import com.cebolutions.top.car.repository.CarroRepository;
import com.cebolutions.top.car.repository.CarroVendaRepository;
import com.cebolutions.top.car.repository.CorRepository;
import com.cebolutions.top.car.repository.UserRepository;
import com.cebolutions.top.car.repository.VendaRepository;
import com.cebolutions.top.car.service.VendaService;

@RestController
@RequestMapping(value="/venda")
public class VendaController {
	
	@Autowired
	private VendaRepository repository;
	
	@Autowired
	private CarroVendaRepository carroVendaRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CorRepository corRepository;
	
	@Autowired
	private CarroRepository carroRepository;
	
	@Autowired
	private VendaService service;
	
	public static final String MIN_QUANTITY = "carro.min.quantity";
	
	@Transactional
	@RequestMapping(method=POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public VendaDTO create(@RequestBody VendaForm form){
		
		Venda venda = new Venda();
		CarroVenda carroPersonalizado = carroVendaRepository.findOne(form.getCarroId());
		Carro carro = carroRepository.findOne(carroPersonalizado.getId());
		Cor cor = corRepository.findOne(carroPersonalizado.getCor().getId());
		
		venda.setDataVenda(LocalDateTime.now());
		venda.setCarro(carroVendaRepository.findOne(form.getCarroId()));
		venda.setUsuario(userRepository.findOne(form.getUsuarioId()));
		venda.setValorTotal(service.valorVendaTotal(carroPersonalizado.getId(), cor.getId()));
		venda.setVendaCompleta(false);
		
		if(carro.getQuantidade() > 2){
			carro.setQuantidade(carro.getQuantidade() - 1);
			venda = repository.save(venda);
		}
		
		venda = repository.save(venda);
		return new VendaDTO(venda);
	}
	
	@Transactional
	@RequestMapping(method=PUT)
	public VendaDTO update(@PathVariable("id") Long id){
		Venda venda = repository.findOne(id);
		User user = userRepository.findOne(venda.getUsuario().getId());
		Carro carro = carroRepository.findOne(venda.getCarro().getCarro().getId());
		
		if(user.getAprovado()){
			venda.setVendaCompleta(true);
			venda = repository.save(venda);
		} if(!user.getAprovado()) {
			venda.setVendaCompleta(false);
			carro.setQuantidade(carro.getQuantidade() + 1);
			venda = repository.save(venda);
		} else {
			carro.setQuantidade(carro.getQuantidade() + 1);
			repository.delete(venda.getId());
			carroVendaRepository.delete(venda.getCarro().getId());
		}
		
		return new VendaDTO(venda);
	}
	
/*	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@Transactional
	public List<Venda> delete(@PathVariable("id") Long id) {
		List<Venda> findAll = new ArrayList<Venda>();
		repository.delete(id);
		findAll = (List<Venda>) repository.findAll();

		return findAll;
	}*/

}
