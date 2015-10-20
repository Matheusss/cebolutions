package com.cebolutions.top.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cebolutions.top.car.entity.CarroVenda;
import com.cebolutions.top.car.entity.Cor;
import com.cebolutions.top.car.repository.CarroVendaRepository;
import com.cebolutions.top.car.repository.CorRepository;

@Service
public class VendaService {
	
	@Autowired
	private CarroVendaRepository carroVendaRepository;
	
	@Autowired
	private CorRepository corRepository;

	public Double valorVendaTotal(Long carroId, Long corId){
		Double valorTotal = 0.0;
		CarroVenda carro = carroVendaRepository.findOne(carroId);
		Cor cor = corRepository.findOne(corId);
		
		valorTotal = carro.getCarro().getPreco() + cor.getValor();
		
		
		return valorTotal;
	}
	
}
